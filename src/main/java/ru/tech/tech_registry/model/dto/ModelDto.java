package ru.tech.tech_registry.model.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import ru.tech.tech_registry.product.model.Product;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class ModelDto {
    private final Long id;
    @NotNull
    private final String name;
    @NotNull
    @NotEmpty
    private final String serialNumber;
    @NotNull
    private final String color;
    @NotNull
    private final String size;
    @NotNull
    private final Double price;
    @NotNull
    private final Boolean inStock;
    @NotNull
    @JsonBackReference
    private final Product product;

    public ModelDto(Long id,
                    String name,
                    String serialNumber,
                    String color,
                    String size,
                    Double price,
                    Boolean inStock,
                    Product product) {
        this.id = id;
        this.name = name;
        this.serialNumber = serialNumber;
        this.color = color;
        this.size = size;
        this.price = price;
        this.inStock = inStock;
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ModelDto)) return false;
        ModelDto modelDto = (ModelDto) o;
        return Objects.equals(id, modelDto.id) && Objects.equals(name, modelDto.name) && Objects.equals(serialNumber, modelDto.serialNumber) && Objects.equals(color, modelDto.color) && Objects.equals(size, modelDto.size) && Objects.equals(price, modelDto.price) && Objects.equals(inStock, modelDto.inStock) && Objects.equals(product, modelDto.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, serialNumber, color, size, price, inStock, product);
    }

    public Long getId() {
        return id;
    }

    public @NotNull String getName() {
        return name;
    }

    public @NotNull @NotEmpty String getSerialNumber() {
        return serialNumber;
    }

    public @NotNull String getColor() {
        return color;
    }

    public @NotNull String getSize() {
        return size;
    }

    public @NotNull Double getPrice() {
        return price;
    }

    public @NotNull Boolean getInStock() {
        return inStock;
    }

    public @NotNull Product getProduct() {
        return product;
    }
}
