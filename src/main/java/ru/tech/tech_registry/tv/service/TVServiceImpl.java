package ru.tech.tech_registry.tv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tech.tech_registry.exception.exception.NotFoundException;
import ru.tech.tech_registry.model.mapper.ModelMapper;
import ru.tech.tech_registry.product.model.Product;
import ru.tech.tech_registry.product.repository.ProductRepository;
import ru.tech.tech_registry.tv.dto.TVDto;
import ru.tech.tech_registry.tv.model.TV;
import ru.tech.tech_registry.tv.repository.TVRepository;

@Service
@Transactional
public class TVServiceImpl implements TVService {
    @Autowired
    private TVRepository tvRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public TVDto create(Long productId, TVDto tvDto) {
        TV tv = mapper.toTV(tvDto);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Product not found"));

        tv.setProduct(product);
        tv.setCategory(tvDto.getCategory());
        tv.setTechnology(tvDto.getTechnology());

        tv = tvRepository.save(tv);
        return mapper.toTVDto(tv);
    }
}
