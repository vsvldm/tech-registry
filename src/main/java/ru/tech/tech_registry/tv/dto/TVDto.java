package ru.tech.tech_registry.tv.dto;

import ru.tech.tech_registry.model.dto.ModelDto;
import ru.tech.tech_registry.product.dto.ProductDto;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class TVDto extends ModelDto {
    @NotNull
    private String category;
    @NotNull
    private String technology;

    public TVDto(Long id,
                 String name,
                 String serialNumber,
                 String color,
                 String size,
                 Double price,
                 Boolean inStock,
                 ProductDto productDto,
                 String category,
                 String technology) {
        super(id, name, serialNumber, color, size, price, inStock, productDto);
        this.category = category;
        this.technology = technology;
    }

    public void setCategory(@NotNull String category) {
        this.category = category;
    }

    public void setTechnology(@NotNull String technology) {
        this.technology = technology;
    }

    public String getCategory() {
        return category;
    }

    public String getTechnology() {
        return technology;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TVDto)) return false;
        if (!super.equals(o)) return false;
        TVDto tvDto = (TVDto) o;
        return Objects.equals(category, tvDto.category) && Objects.equals(technology, tvDto.technology);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), category, technology);
    }
}
