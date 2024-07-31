package ru.tech.tech_registry.product.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import ru.tech.tech_registry.model.model.Model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "products", uniqueConstraints = @UniqueConstraint(columnNames = {"name", "country", "manufacturer"}))
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private String manufacturer;
    private Boolean onlineOrder;
    private Boolean installment;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Model> models;

    public Product() {
    }

    public Product(Long id, String name, String country, String manufacturer, Boolean onlineOrder, Boolean installment, List<Model> models) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.manufacturer = manufacturer;
        this.onlineOrder = onlineOrder;
        this.installment = installment;
        this.models = models;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setOnlineOrder(Boolean onlineOrder) {
        this.onlineOrder = onlineOrder;
    }

    public void setInstallment(Boolean installment) {
        this.installment = installment;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Boolean getOnlineOrder() {
        return onlineOrder;
    }

    public Boolean getInstallment() {
        return installment;
    }

    public List<Model> getModels() {
        return models;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(country, product.country) && Objects.equals(manufacturer, product.manufacturer) && Objects.equals(onlineOrder, product.onlineOrder) && Objects.equals(installment, product.installment) && Objects.equals(models, product.models);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country, manufacturer, onlineOrder, installment, models);
    }
}
