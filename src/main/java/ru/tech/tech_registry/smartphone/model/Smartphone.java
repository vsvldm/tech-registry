package ru.tech.tech_registry.smartphone.model;

import ru.tech.tech_registry.model.model.Model;

import javax.persistence.*;

@Entity
public class Smartphone extends Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer memory;
    private Integer cameras;
    @JoinColumn(name = "model_id")
    private Model model;
}
