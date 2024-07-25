package ru.tech.tech_registry.vacuum_cleaner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tech.tech_registry.vacuum_cleaner.model.VacuumCleaner;

public interface VacuumCleanerRepository extends JpaRepository<VacuumCleaner, Long> {
}
