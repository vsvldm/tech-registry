package ru.tech.tech_registry.refrigerator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.tech.tech_registry.exception.exception.NotFoundException;
import ru.tech.tech_registry.model.mapper.ModelMapper;
import ru.tech.tech_registry.product.model.Product;
import ru.tech.tech_registry.product.repository.ProductRepository;
import ru.tech.tech_registry.refrigerator.dto.RefrigeratorDto;
import ru.tech.tech_registry.refrigerator.model.Refrigerator;
import ru.tech.tech_registry.refrigerator.repository.RefrigeratorRepository;

@Service
@Transactional
public class RefrigeratorServiceImpl implements RefrigeratorService {
    @Autowired
    private RefrigeratorRepository refrigeratorRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public RefrigeratorDto create(Long productId, RefrigeratorDto refrigeratorDto) {
        Refrigerator refrigerator = mapper.toRefrigerator(refrigeratorDto);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Product not found"));

        refrigerator.setProduct(product);
        refrigerator.setDoorCount(refrigeratorDto.getDoorCount());
        refrigerator.setCompressorType(refrigeratorDto.getCompressorType());

        refrigerator = refrigeratorRepository.save(refrigerator);
        return mapper.toRefrigeratorDto(refrigerator);
    }
}
