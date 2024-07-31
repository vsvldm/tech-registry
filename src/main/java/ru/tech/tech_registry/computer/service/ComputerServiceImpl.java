package ru.tech.tech_registry.computer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.tech.tech_registry.computer.dto.ComputerDto;
import ru.tech.tech_registry.computer.model.Computer;
import ru.tech.tech_registry.computer.repository.ComputerRepository;
import ru.tech.tech_registry.exception.exception.BadRequestException;
import ru.tech.tech_registry.exception.exception.NotFoundException;
import ru.tech.tech_registry.model.mapper.ModelMapper;
import ru.tech.tech_registry.product.mapper.ProductMapper;
import ru.tech.tech_registry.product.model.Product;
import ru.tech.tech_registry.product.repository.ProductRepository;

@Service
@Transactional
public class ComputerServiceImpl implements ComputerService {
    @Autowired
    private ComputerRepository computerRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public ComputerDto create(Long productId, ComputerDto computerDto) {
        Computer computer = mapper.toComputer(computerDto);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Product not found"));

        computer.setProduct(product);
        computer.setCategory(computerDto.getCategory());
        computer.setProcessorType(computerDto.getProcessorType());
        
        computer = computerRepository.save(computer);
        return mapper.toComputerDto(computer);
    }
}
