package ru.tech.tech_registry.vacuum_cleaner.service;

import ru.tech.tech_registry.vacuum_cleaner.dto.VacuumCleanerDto;

public interface VacuumCleanerService {
    VacuumCleanerDto create(VacuumCleanerDto vacuumCleanerDto);

    VacuumCleanerDto update(Long cleanerId, VacuumCleanerDto vacuumCleanerDto);
}
