package ru.tech.tech_registry.refrigerator.dto;

import ru.tech.tech_registry.model.dto.ModelDto;
import ru.tech.tech_registry.product.dto.ProductDto;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class RefrigeratorDto extends ModelDto {
    @NotNull
    private Integer doorCount;
    @NotNull
    private String compressorType;

    public RefrigeratorDto(Long id,
                           String name,
                           String serialNumber,
                           String color,
                           String size,
                           Double price,
                           Boolean inStock,
                           ProductDto productDto,
                           Integer doorCount,
                           String compressorType) {
        super(id, name, serialNumber, color, size, price, inStock, productDto);
        this.doorCount = doorCount;
        this.compressorType = compressorType;
    }

    public void setDoorCount(Integer doorCount) {
        this.doorCount = doorCount;
    }

    public void setCompressorType(String compressorType) {
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
