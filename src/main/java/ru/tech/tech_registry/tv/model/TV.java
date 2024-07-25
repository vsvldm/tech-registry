package ru.tech.tech_registry.tv.model;

import ru.tech.tech_registry.model.model.Model;

import javax.persistence.*;

@Entity
@Table(name = "tvs")
public class TV extends Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String category;
    private String technology;
    @JoinColumn(name = "model_id")
    private Model model;
}
