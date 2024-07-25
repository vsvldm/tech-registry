package ru.tech.tech_registry.computer.model;

import ru.tech.tech_registry.model.model.Model;

import javax.persistence.*;

@Entity
@Table(name = "computers")
public class Computer extends Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String category;
    private String processorType;
    @JoinColumn(name = "model_id")
    private Model model;
}
