package ru.tech.tech_registry.smartphone.service;

import ru.tech.tech_registry.smartphone.dto.SmartphoneDto;

public interface SmartphoneService {
    SmartphoneDto create(Long productId, SmartphoneDto smartphoneDto);
}
