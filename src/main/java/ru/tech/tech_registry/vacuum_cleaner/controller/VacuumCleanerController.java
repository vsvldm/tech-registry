package ru.tech.tech_registry.vacuum_cleaner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import ru.tech.tech_registry.vacuum_cleaner.dto.VacuumCleanerDto;
import ru.tech.tech_registry.vacuum_cleaner.service.VacuumCleanerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/vacuumcleaners")
public class VacuumCleanerController {

    @Autowired
    private VacuumCleanerService vacuumCleanerService;

    @Operation(summary = "Create a new vacuum cleaner",
            description = "Creates a new vacuum cleaner with the provided details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vacuum cleaner successfully created",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = VacuumCleanerDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Not found product",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)
    })
    @PostMapping("/{productId}")
    public VacuumCleanerDto create(@Parameter(description = "ID of the product to which the model belongs")
                                   @PathVariable Long productId,
                                   @Parameter(description = "Details of the vacuum cleaner to be created")
                                   @RequestBody VacuumCleanerDto vacuumCleanerDto) {
        return vacuumCleanerService.create(productId, vacuumCleanerDto);
    }
}
