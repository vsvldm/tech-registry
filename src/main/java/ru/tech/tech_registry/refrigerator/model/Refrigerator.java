package ru.tech.tech_registry.refrigerator.model;

import ru.tech.tech_registry.model.model.Model;

import javax.persistence.*;

@Entity
@Table(name = "refrigerators")
public class Refrigerator extends Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer doorCount;
    private String compressorType;
    @JoinColumn(name = "model_id")
    private Model model;
}
