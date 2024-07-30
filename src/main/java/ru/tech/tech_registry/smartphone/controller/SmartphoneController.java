package ru.tech.tech_registry.smartphone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import ru.tech.tech_registry.smartphone.dto.SmartphoneDto;
import ru.tech.tech_registry.smartphone.service.SmartphoneService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/smartphones")
public class SmartphoneController {
    @Autowired
    private SmartphoneService smartphoneService;

    @Operation(summary = "Create a new smartphone", 
               description = "Creates a new smartphone with the provided details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Smartphone successfully created", 
                         content = @Content(mediaType = "application/json", 
                                            schema = @Schema(implementation = SmartphoneDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input", 
                         content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", 
                         content = @Content)
    })
    @PostMapping
    public SmartphoneDto create(@Parameter(description = "Details of the smartphone to be created") 
                                @RequestBody SmartphoneDto smartphoneDto) {
        return smartphoneService.create(smartphoneDto);
    }

    @Operation(summary = "Update an existing smartphone", 
               description = "Updates the details of an existing smartphone identified by the provided ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Smartphone successfully updated", 
                         content = @Content(mediaType = "application/json", 
                                            schema = @Schema(implementation = SmartphoneDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input", 
                         content = @Content),
            @ApiResponse(responseCode = "404", description = "Smartphone not found", 
                         content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", 
                         content = @Content)
    })
    @PutMapping("/{smartphoneId}")
    public SmartphoneDto update(@Parameter(description = "ID of the smartphone to be updated") 
                                @PathVariable Long smartphoneId, 
                                @Parameter(description = "Details of the smartphone to be updated") 
                                @RequestBody SmartphoneDto smartphoneDto) {   
        return smartphoneService.update(smartphoneId, smartphoneDto);
    }
}
