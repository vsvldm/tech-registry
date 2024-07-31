package ru.tech.tech_registry.vacuum_cleaner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.tech.tech_registry.exception.exception.NotFoundException;
import ru.tech.tech_registry.model.mapper.ModelMapper;
import ru.tech.tech_registry.product.model.Product;
import ru.tech.tech_registry.product.repository.ProductRepository;
import ru.tech.tech_registry.vacuum_cleaner.dto.VacuumCleanerDto;
import ru.tech.tech_registry.vacuum_cleaner.model.VacuumCleaner;
import ru.tech.tech_registry.vacuum_cleaner.repository.VacuumCleanerRepository;

@Service
@Transactional
public class VacuumCleanerServiceImpl implements VacuumCleanerService {
    @Autowired
    private VacuumCleanerRepository vacuumCleanerRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public VacuumCleanerDto create(Long productId, VacuumCleanerDto vacuumCleanerDto) {
        VacuumCleaner vacuumCleaner = mapper.toVacuumCleaner(vacuumCleanerDto);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Product not found"));

        vacuumCleaner.setProduct(product);
        vacuumCleaner.setDustCollectorVolume(vacuumCleanerDto.getDustCollectorVolume());
        vacuumCleaner.setModes(vacuumCleanerDto.getModes());

        vacuumCleaner = vacuumCleanerRepository.save(vacuumCleaner);
        return mapper.toVacuumCleanerDto(vacuumCleaner);
    }
}
