package ru.tech.tech_registry.smartphone.service;

import ru.tech.tech_registry.smartphone.dto.SmartphoneDto;

public interface SmartphoneService {
    SmartphoneDto create(SmartphoneDto smartphoneDto);

    SmartphoneDto update(Long smartId, SmartphoneDto smartphoneDto);
}
