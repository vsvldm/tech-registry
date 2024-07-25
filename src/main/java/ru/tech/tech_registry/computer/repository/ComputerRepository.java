package ru.tech.tech_registry.computer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tech.tech_registry.computer.model.Computer;

public interface ComputerRepository extends JpaRepository<Computer, Long> {
}
