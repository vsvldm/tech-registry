package ru.tech.tech_registry.smartphone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tech.tech_registry.smartphone.model.Smartphone;

public interface SmartphoneRepository extends JpaRepository<Smartphone, Long> {
}
