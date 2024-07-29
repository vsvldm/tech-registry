package ru.tech.tech_registry.tv.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.tech.tech_registry.tv.dto.TVDto;
import ru.tech.tech_registry.tv.service.TVService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tv")
public class TVController {
    @Autowired
    private TVService tvService;

    @Operation(summary = "Create new tv")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "TV successfully created"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public TVDto create(@Valid @RequestBody TVDto tvDto) {
        return tvService.create(tvDto);
    }

    @Operation(summary = "Updating an existing TV")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "TV successfully updated"),
            @ApiResponse(responseCode = "404", description = "TV not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping
    public TVDto update(@Valid @RequestBody TVDto tvDto) {
        return tvService.update(tvDto);
    }

    @Operation(summary = "Get TV by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "TV successfully found"),
            @ApiResponse(responseCode = "404", description = "TV not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{modelId}")
    public TVDto getTVById(@PathVariable Long modelId) {
        return tvService.getTVById(modelId);
    }

    @Operation(summary = "Get all TVs")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the TVs"),
            @ApiResponse(responseCode = "404", description = "TVs not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public List<TVDto> getAllTVs() {
        return tvService.getAllTV();
    }

    @Operation(summary = "Delete TV")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "TV successfully deleted"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping("/{modelId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long modelId) {
        tvService.deleteById(modelId);
    }
}
