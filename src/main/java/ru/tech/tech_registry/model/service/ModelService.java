package ru.tech.tech_registry.model.service;

import ru.tech.tech_registry.model.dto.ModelDto;
import ru.tech.tech_registry.model.model.Model;

import java.util.List;

public interface ModelService {
    ModelDto getModelById(Long modelId);

    List<ModelDto> getAllModels();

    void deleteById(Long modelId);

    List<ModelDto> searchModels(String name,
                                String color,
                                Double minPrice,
                                Double maxPrice,
                                Class<? extends Model> type,
                                String sortBy);
}
