package ru.tech.tech_registry.tv.dto;

import ru.tech.tech_registry.model.dto.ModelDto;
import ru.tech.tech_registry.product.model.Product;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class TVDto extends ModelDto {
    @NotNull
    private String category;
    @NotNull
    private String technology;
    @NotNull
    private Long productId;

    public TVDto(Long id,
                 String name,
                 String serialNumber,
                 String color,
                 String size,
                 Double price,
                 Boolean inStock,
                 Product product,
                 String category,
                 String technology,
                 Long productId) {
        super(id, name, serialNumber, color, size, price, inStock, product);
        this.category = category;
        this.technology = technology;
        this.productId = productId;
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

    public Long getProductId() {
        return productId;
    }
}
