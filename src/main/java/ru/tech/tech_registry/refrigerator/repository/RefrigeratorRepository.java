package ru.tech.tech_registry.refrigerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tech.tech_registry.refrigerator.model.Refrigerator;

public interface RefrigeratorRepository extends JpaRepository<Refrigerator, Long> {
}
