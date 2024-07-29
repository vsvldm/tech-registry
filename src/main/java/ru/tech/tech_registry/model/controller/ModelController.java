package ru.tech.tech_registry.model.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tech.tech_registry.model.dto.ModelDto;
import ru.tech.tech_registry.model.model.Model;
import ru.tech.tech_registry.model.service.ModelService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/model")
public class ModelController {
    @Autowired
    private ModelService modelService;

    @Operation(summary = "Create new model")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product successfully created"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/search")
    public List<ModelDto> searchModels(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Class<? extends Model> type,
            @RequestParam(required = false) String sortBy) {
        return modelService.searchModels(name, color, minPrice, maxPrice, type, sortBy);
    }
}
