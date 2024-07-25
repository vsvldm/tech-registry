package ru.tech.tech_registry.vacuum_cleaner.model;

import ru.tech.tech_registry.model.model.Model;

import javax.persistence.*;

@Entity
@Table(name = "vacuum_cleaners")
public class VacuumCleaner extends Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double dustCollectorVolume;
    private Integer modes;
    @JoinColumn(name = "model_id")
    private Model model;
}
