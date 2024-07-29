package ru.tech.tech_registry.smartphone.dto;

import ru.tech.tech_registry.model.dto.ModelDto;
import ru.tech.tech_registry.product.model.Product;

import java.util.Objects;

public class SmartphoneDto extends ModelDto {
    private Integer memory;
    private Integer cameras;

    public SmartphoneDto(Long id,
                         String name,
                         String serialNumber,
                         String color,
                         String size,
                         Double price,
                         Boolean inStock,
                         Product product,
                         Integer memory,
                         Integer cameras) {
        super(id, name, serialNumber, color, size, price, inStock, product);
        this.memory = memory;
        this.cameras = cameras;
    }

    public Integer getMemory() {
        return memory;
    }

    public Integer getCameras() {
        return cameras;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SmartphoneDto)) return false;
        if (!super.equals(o)) return false;
        SmartphoneDto that = (SmartphoneDto) o;
        return Objects.equals(memory, that.memory) && Objects.equals(cameras, that.cameras);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), memory, cameras);
    }
}
