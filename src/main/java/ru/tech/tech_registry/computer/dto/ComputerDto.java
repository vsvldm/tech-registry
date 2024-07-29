package ru.tech.tech_registry.computer.dto;

import ru.tech.tech_registry.model.dto.ModelDto;
import ru.tech.tech_registry.product.model.Product;

import java.util.Objects;

public class ComputerDto extends ModelDto {
    private String category;
    private String processorType;

    public ComputerDto(Long id,
                       String name,
                       String serialNumber,
                       String color,
                       String size,
                       Double price,
                       Boolean inStock,
                       Product product,
                       String category,
                       String processorType) {
        super(id, name, serialNumber, color, size, price, inStock, product);
        this.category = category;
        this.processorType = processorType;
    }

    public String getCategory() {
        return category;
    }

    public String getProcessorType() {
        return processorType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComputerDto)) return false;
        if (!super.equals(o)) return false;
        ComputerDto that = (ComputerDto) o;
        return Objects.equals(category, that.category) && Objects.equals(processorType, that.processorType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), category, processorType);
    }
}
