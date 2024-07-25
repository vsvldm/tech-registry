package ru.tech.tech_registry.tv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tech.tech_registry.tv.model.TV;

public interface TVRepository extends JpaRepository<TV, Long> {
}
