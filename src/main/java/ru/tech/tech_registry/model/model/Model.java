package ru.tech.tech_registry.model.model;

import ru.tech.tech_registry.product.model.Product;

import javax.persistence.*;

@Entity
@Table(name = "models")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "model_name")
    private String modelName;
    @Column(name = "serial_number")
    private String serialNumber;
    private String color;
    @Column(name = "model_size")
    private String size;
    private Double price;
    @Column(name = "in_stock")
    private Boolean inStock;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
