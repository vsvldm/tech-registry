package ru.tech.tech_registry.computer.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.tech.tech_registry.computer.repository.ComputerRepository;

public class ComputerServiceImpl implements ComputerServie {
    @Autowired
    private ComputerRepository computerRepository;

}
