package ru.tech.tech_registry.smartphone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.tech.tech_registry.exception.exception.NotFoundException;
import ru.tech.tech_registry.model.mapper.ModelMapper;
import ru.tech.tech_registry.product.model.Product;
import ru.tech.tech_registry.product.repository.ProductRepository;
import ru.tech.tech_registry.smartphone.dto.SmartphoneDto;
import ru.tech.tech_registry.smartphone.model.Smartphone;
import ru.tech.tech_registry.smartphone.repository.SmartphoneRepository;

@Service
@Transactional
public class SmartphoneServiceImpl implements SmartphoneService {
    @Autowired
    private SmartphoneRepository smartphoneRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public SmartphoneDto create(Long productId, SmartphoneDto smartphoneDto) {
        Smartphone smartphone = mapper.toSmartphone(smartphoneDto);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Product not found"));

        smartphone.setProduct(product);
        smartphone.setMemory(smartphoneDto.getMemory());
        smartphone.setCameras(smartphoneDto.getCameras());

        smartphone = smartphoneRepository.save(smartphone);
        return mapper.toSmartphoneDto(smartphone);
    }
}
