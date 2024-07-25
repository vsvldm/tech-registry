package ru.tech.tech_registry.product.model;

import ru.tech.tech_registry.model.model.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_name")
    private String productName;
    private String country;
    private String manufacturer;
    @Column(name = "online_order")
    private Boolean onlineOrder;
    private Boolean installment;
    @OneToMany(mappedBy = "product")
    private List<Model> models;
}
