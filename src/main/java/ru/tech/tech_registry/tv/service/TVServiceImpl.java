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

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class TVServiceImpl implements TVService {
    @Autowired
    private TVRepository tvRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapper mapper;

    @Transactional
    @Override
    public TVDto create(TVDto tvDto) {
        TV tv = mapper.toTV(tvDto);
        Product product = productRepository.findById(1L)
                .orElseThrow(() -> new NotFoundException("Product not found."));
        tv.setProduct(product);
        return mapper.toTVDto(tvRepository.save(mapper.toTV(tvDto)));
    }

    @Transactional
    @Override
    public TVDto update(TVDto tvDto) {
        return null;
    }

    @Override
    public TVDto getTVById(Long modelId) {
        TV tv = tvRepository.findById(modelId)
                .orElseThrow(() -> new NotFoundException("Model not found."));
        return mapper.toTVDto(tv);
    }

    @Override
    public List<TVDto> getAllTV() {
        return tvRepository.findAll().stream()
                .map(mapper::toTVDto)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void deleteById(Long modelId) {
        tvRepository.deleteById(modelId);
    }
}
