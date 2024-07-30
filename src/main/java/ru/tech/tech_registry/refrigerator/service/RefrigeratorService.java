package ru.tech.tech_registry.refrigerator.service;

import ru.tech.tech_registry.refrigerator.dto.RefrigeratorDto;

public interface RefrigeratorService {
    RefrigeratorDto create(RefrigeratorDto refrigeratorDto);

    RefrigeratorDto update(Long refId, RefrigeratorDto refrigeratorDto);
}
