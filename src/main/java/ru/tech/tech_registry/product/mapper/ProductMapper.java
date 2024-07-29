package ru.tech.tech_registry.product.mapper;

import org.mapstruct.Mapper;
import ru.tech.tech_registry.model.mapper.ModelMapper;
import ru.tech.tech_registry.product.dto.ProductDto;
import ru.tech.tech_registry.product.model.Product;

@Mapper(componentModel = "spring", uses = {ModelMapper.class})
public interface ProductMapper {
    ProductDto toProductDto(Product product);

    Product toProduct(ProductDto productDto);
}
