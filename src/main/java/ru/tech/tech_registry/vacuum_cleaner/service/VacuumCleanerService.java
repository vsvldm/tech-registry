package ru.tech.tech_registry.vacuum_cleaner.service;

import ru.tech.tech_registry.vacuum_cleaner.dto.VacuumCleanerDto;

public interface VacuumCleanerService {
    VacuumCleanerDto create(Long productId, VacuumCleanerDto vacuumCleanerDto);
}
