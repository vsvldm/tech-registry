package ru.tech.tech_registry.tv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import ru.tech.tech_registry.tv.dto.TVDto;
import ru.tech.tech_registry.tv.service.TVService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/tvs")
public class TVController {
    @Autowired
    private TVService tvService;

    @Operation(summary = "Create a new TV", 
               description = "Creates a new TV with the provided details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "TV successfully created", 
                         content = @Content(mediaType = "application/json", 
                                            schema = @Schema(implementation = TVDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input", 
                         content = @Content),
            @ApiResponse(responseCode = "404", description = "Not found product",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", 
                         content = @Content)
    })
    @PostMapping("/{productId}")
    public TVDto create(@Parameter(description = "ID of the product to which the model belongs")
                        @PathVariable Long productId,
                        @Parameter(description = "Details of the TV to be created")
                        @RequestBody TVDto tvDto) {
        return tvService.create(productId, tvDto);
    }
}
