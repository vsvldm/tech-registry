package ru.tech.tech_registry.smartphone.dto;

import ru.tech.tech_registry.model.dto.ModelDto;
import ru.tech.tech_registry.product.dto.ProductDto;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class SmartphoneDto extends ModelDto {
    @NotNull
    private Integer memory;
    @NotNull
    private Integer cameras;

    public SmartphoneDto(Long id,
                         String name,
                         String serialNumber,
                         String color,
                         String size,
                         Double price,
                         Boolean inStock,
                         ProductDto productDto,
                         Integer memory,
                         Integer cameras) {
        super(id, name, serialNumber, color, size, price, inStock, productDto);
        this.memory = memory;
        this.cameras = cameras;
    }

    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    public void setCameras(Integer cameras) {
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
