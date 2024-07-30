package ru.tech.tech_registry.refrigerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import ru.tech.tech_registry.refrigerator.dto.RefrigeratorDto;
import ru.tech.tech_registry.refrigerator.service.RefrigeratorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/refrigerators")
public class RefrigeratorController {
    @Autowired
    private RefrigeratorService refrigeratorService;

    @Operation(summary = "Create a new refrigerator", 
               description = "Creates a new refrigerator with the provided details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Refrigerator successfully created", 
                         content = @Content(mediaType = "application/json", 
                                            schema = @Schema(implementation = RefrigeratorDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input", 
                         content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", 
                         content = @Content)
    })
    @PostMapping
    public RefrigeratorDto create(@Parameter(description = "Details of the refrigerator to be created") 
                                  @RequestBody RefrigeratorDto refrigeratorDto) {
        return refrigeratorService.create(refrigeratorDto);
    }

    @Operation(summary = "Update an existing refrigerator", 
               description = "Updates the details of an existing refrigerator identified by the provided ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Refrigerator successfully updated", 
                         content = @Content(mediaType = "application/json", 
                                            schema = @Schema(implementation = RefrigeratorDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input", 
                         content = @Content),
            @ApiResponse(responseCode = "404", description = "Refrigerator not found", 
                         content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", 
                         content = @Content)
    })
    @PutMapping("/{refrigeratorId}")
    public RefrigeratorDto update(@Parameter(description = "ID of the refrigerator to be updated") 
                                  @PathVariable Long refrigeratorId, 
                                  @Parameter(description = "Details of the refrigerator to be updated") 
                                  @RequestBody RefrigeratorDto refrigeratorDto) {   
        return refrigeratorService.update(refrigeratorId, refrigeratorDto);
    }
}
