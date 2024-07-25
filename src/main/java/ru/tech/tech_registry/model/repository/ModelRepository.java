package ru.tech.tech_registry.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tech.tech_registry.model.model.Model;

public interface ModelRepository extends JpaRepository<Model, Long> {
}
