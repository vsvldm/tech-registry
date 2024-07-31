package ru.tech.tech_registry.computer.service;

import ru.tech.tech_registry.computer.dto.ComputerDto;

public interface ComputerService {
    ComputerDto create(Long productId, ComputerDto computerDto);
}
