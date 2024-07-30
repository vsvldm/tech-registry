package ru.tech.tech_registry.model.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tech.tech_registry.model.dto.ModelDto;
import ru.tech.tech_registry.model.model.Model;
import ru.tech.tech_registry.model.service.ModelService;

import java.util.List;

@RestController
@RequestMapping("/model")
public class ModelController {
    @Autowired
    private ModelService modelService;

    @Operation(summary = "Get model by ID", 
               description = "Retrieves the details of the model identified by the provided ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Model successfully found", 
                         content = @Content(mediaType = "application/json", 
                                            schema = @Schema(implementation = ModelDto.class))),
            @ApiResponse(responseCode = "404", description = "Model not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{modelId}")
    public ModelDto getModelById(@Parameter(description = "ID of the model to be retrieved") @PathVariable Long modelId) {
        return modelService.getModelById(modelId);
    }
    
    @Operation(summary = "Get all models", 
               description = "Retrieves a list of all models in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the models", 
                         content = @Content(mediaType = "application/json", 
                                            schema = @Schema(implementation = ModelDto.class))),
            @ApiResponse(responseCode = "404", description = "Models not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public List<ModelDto> getAllModels() {
        return modelService.getAllModels();
    }

    @Operation(summary = "Delete model by ID", 
               description = "Deletes the model identified by the provided ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Model successfully deleted"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping("/{modelId}")
    public void deleteById(@Parameter(description = "ID of the model to be deleted") @PathVariable Long modelId) {
        modelService.deleteById(modelId);
    }

    @Operation(summary = "Search models", description = "Search models by name, color, price range, type, and sort by specified field")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the models",
                    content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ModelDto.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Models not found",
                    content = @Content) })
    @GetMapping("/search")
    public List<ModelDto> searchModels(
            @Parameter(description = "Name of the model") @RequestParam(required = false) String name,
            @Parameter(description = "Color of the model") @RequestParam(required = false) String color,
            @Parameter(description = "Minimum price of the model") @RequestParam(required = false) Double minPrice,
            @Parameter(description = "Maximum price of the model") @RequestParam(required = false) Double maxPrice,
            @Parameter(description = "Type of the model") @RequestParam(required = false) Class<? extends Model> type,
            @Parameter(description = "Field to sort by") @RequestParam(required = false) String sortBy) {
        return modelService.searchModels(name, color, minPrice, maxPrice, type, sortBy);
    }
}