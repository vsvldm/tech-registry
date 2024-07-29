package ru.tech.tech_registry.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.tech.tech_registry.exception.exception.NotFoundException;
import ru.tech.tech_registry.model.dto.ModelDto;
import ru.tech.tech_registry.model.mapper.ModelMapper;
import ru.tech.tech_registry.model.model.Model;
import ru.tech.tech_registry.model.repository.ModelRepository;
import ru.tech.tech_registry.model.specificaton.ModelSpecification;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements ModelService {
    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ModelDto create(ModelDto modelDto) {
        return null;
    }

    @Override
    public ModelDto getModelById(Long modelId) {
        Model model = modelRepository.findById(modelId)
                .orElseThrow(() -> new NotFoundException("Model not found."));
        return modelMapper.toModelDto(model);
    }

    @Override
    public List<ModelDto> getAllModel() {
        return List.of();
    }

    @Override
    public void deleteById(Long modelId) {
        modelRepository.deleteById(modelId);
    }

    @Override
    public List<ModelDto> searchModels(String name,
                                       String color,
                                       Double minPrice,
                                       Double maxPrice,
                                       Class<? extends Model> type,
                                       String sortBy) {
        Specification<Model> spec = Specification.where(null);

        if (name != null && !name.isEmpty()) {
            spec = spec.and(ModelSpecification.hasName(name));
        }
        if (color != null && !color.isEmpty()) {
            spec = spec.and(ModelSpecification.hasColor(color));
        }
        if (minPrice != null && maxPrice != null) {
            spec = spec.and(ModelSpecification.hasPriceBetween(minPrice, maxPrice));
        }
        if (type != null) {
            spec = spec.and(ModelSpecification.hasType(type));
        }

        return modelRepository.findAll(spec, Sort.by(Sort.Order.asc(sortBy))).stream()
                .map(modelMapper::toModelDto)
                .collect(Collectors.toList());
    }
}
