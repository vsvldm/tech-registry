package ru.tech.tech_registry.model.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonSubTypes;

import ru.tech.tech_registry.computer.model.Computer;
import ru.tech.tech_registry.product.dto.ProductDto;
import ru.tech.tech_registry.refrigerator.model.Refrigerator;
import ru.tech.tech_registry.smartphone.model.Smartphone;
import ru.tech.tech_registry.tv.model.TV;
import ru.tech.tech_registry.vacuum_cleaner.model.VacuumCleaner;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@JsonSubTypes({
        @JsonSubTypes.Type(value = Computer.class, name = "computer"),
        @JsonSubTypes.Type(value = Refrigerator.class, name = "refrigerator"),
        @JsonSubTypes.Type(value = Smartphone.class, name = "smartphone"),
        @JsonSubTypes.Type(value = TV.class, name = "tv"),
        @JsonSubTypes.Type(value = VacuumCleaner.class, name = "vacuumCleaner")
})
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
    @JsonBackReference
    private final ProductDto productDto;

    public ModelDto(Long id,
                    String name,
                    String serialNumber,
                    String color,
                    String size,
                    Double price,
                    Boolean inStock,
                    ProductDto productDto) {
        this.id = id;
        this.name = name;
        this.serialNumber = serialNumber;
        this.color = color;
        this.size = size;
        this.price = price;
        this.inStock = inStock;
        this.productDto = productDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ModelDto)) return false;
        ModelDto modelDto = (ModelDto) o;
        return Objects.equals(id, modelDto.id) && Objects.equals(name, modelDto.name) && Objects.equals(serialNumber, modelDto.serialNumber) && Objects.equals(color, modelDto.color) && Objects.equals(size, modelDto.size) && Objects.equals(price, modelDto.price) && Objects.equals(inStock, modelDto.inStock) && Objects.equals(productDto, modelDto.productDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, serialNumber, color, size, price, inStock, productDto);
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

    public @NotNull ProductDto getProductDto() {
        return productDto;
    }
}
