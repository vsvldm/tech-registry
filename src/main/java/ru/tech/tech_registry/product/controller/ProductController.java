package ru.tech.tech_registry.product.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.tech.tech_registry.product.dto.ProductDto;
import ru.tech.tech_registry.product.service.ProductService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Operation(summary = "Create new product", 
               description = "Creates a new product in the system with the provided details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product successfully created", 
                         content = @Content(mediaType = "application/json", 
                                            schema = @Schema(implementation = ProductDto.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public ProductDto create(@Parameter(description = "Details of the product to be created") 
                             @Valid @RequestBody ProductDto productDto) {
        return productService.create(productDto);
    }

    @Operation(summary = "Updating an existing product", 
               description = "Updates the details of an existing product identified by the provided ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product successfully updated", 
                         content = @Content(mediaType = "application/json", 
                                            schema = @Schema(implementation = ProductDto.class))),
            @ApiResponse(responseCode = "404", description = "Product not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping
    public ProductDto update(@Parameter(description = "Details of the product to be updated") 
                             @Valid @RequestBody ProductDto productDto) {
        return productService.update(productDto);
    }

    @Operation(summary = "Delete product", 
               description = "Deletes the product identified by the provided ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Product successfully deleted"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@Parameter(description = "ID of the product to be deleted") 
                           @PathVariable Long productId) {
        productService.deleteById(productId);
    }

    @Operation(summary = "Get product by ID", 
               description = "Retrieves the details of the product identified by the provided ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product successfully found", 
                         content = @Content(mediaType = "application/json", 
                                            schema = @Schema(implementation = ProductDto.class))),
            @ApiResponse(responseCode = "404", description = "Product not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{productId}")
    public ProductDto getProduct(@Parameter(description = "ID of the product to be retrieved") 
                                 @PathVariable Long productId) {
        return productService.getProductById(productId);
    }

    @Operation(summary = "Get all products", 
               description = "Retrieves a list of all products in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the products", 
                         content = @Content(mediaType = "application/json", 
                                            schema = @Schema(implementation = ProductDto.class))),
            @ApiResponse(responseCode = "404", description = "Products not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public List<ProductDto> getAllProducts() {
        return productService.getAllProduct();
    }
}
