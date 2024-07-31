package ru.tech.tech_registry.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tech.tech_registry.exception.exception.NotFoundException;
import ru.tech.tech_registry.product.dto.ProductDto;
import ru.tech.tech_registry.product.mapper.ProductMapper;
import ru.tech.tech_registry.product.model.Product;
import ru.tech.tech_registry.product.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    @Transactional
    @Override
    public ProductDto create(ProductDto productDto) {
        Product product = productMapper.toProduct(productDto);
        return productMapper.toProductDto(productRepository.save(product));
    }

    @Transactional
    @Override
    public ProductDto update(ProductDto product) {
        productRepository.findById(product.getId())
                .orElseThrow(() -> new NotFoundException("Product not found"));
        
        Product saveProduct = productRepository.save(productMapper.toProduct(product));
        return productMapper.toProductDto(saveProduct);
    }

    @Transactional
    @Override
    public void deleteById(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public ProductDto getProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Product not found."));

        return productMapper.toProductDto(product);
    }

    @Override
    public List<ProductDto> getAllProduct() {
        return productRepository.findAll().stream()
                .map(productMapper::toProductDto)
                .collect(Collectors.toList());
    }
}
