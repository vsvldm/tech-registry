package ru.tech.tech_registry.refrigerator.dto;

import ru.tech.tech_registry.model.dto.ModelDto;
import ru.tech.tech_registry.product.model.Product;

import java.util.Objects;

public class RefrigeratorDto extends ModelDto {
    private Integer doorCount;
    private String compressorType;

    public RefrigeratorDto(Long id,
                           String name,
                           String serialNumber,
                           String color,
                           String size,
                           Double price,
                           Boolean inStock,
                           Product product,
                           Integer doorCount,
                           String compressorType) {
        super(id, name, serialNumber, color, size, price, inStock, product);
        this.doorCount = doorCount;
        this.compressorType = compressorType;
    }

    public Integer getDoorCount() {
        return doorCount;
    }

    public String getCompressorType() {
        return compressorType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RefrigeratorDto)) return false;
        if (!super.equals(o)) return false;
        RefrigeratorDto that = (RefrigeratorDto) o;
        return Objects.equals(doorCount, that.doorCount) && Objects.equals(compressorType, that.compressorType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), doorCount, compressorType);
    }
}
