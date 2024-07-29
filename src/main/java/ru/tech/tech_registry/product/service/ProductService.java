package ru.tech.tech_registry.product.service;

import ru.tech.tech_registry.product.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto create(ProductDto productDto);

    ProductDto update(ProductDto productDto);

    void deleteById(Long productId);

    ProductDto getProductById(Long productId);

    List<ProductDto> getAllProduct();
}
