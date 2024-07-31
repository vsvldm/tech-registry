package ru.tech.tech_registry.computer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import ru.tech.tech_registry.computer.dto.ComputerDto;
import ru.tech.tech_registry.computer.service.ComputerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;

@RestController
@RequestMapping("/computers")
public class ComputerController {
    @Autowired
    private ComputerService computerService;

    @Operation(summary = "Create a new computer",
            description = "Creates a new computer with the provided details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Computer successfully created", 
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ComputerDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input", 
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Not found product",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", 
                    content = @Content)
    })
    @PostMapping("/{productId}")
    public ComputerDto create(@Parameter(description = "ID of the product to which the model belongs")
                              @PathVariable Long productId,
                              @Parameter(description = "Details of the computer to be created")
                              @Valid @RequestBody ComputerDto computerDto) {
        return computerService.create(productId, computerDto);
    }
}