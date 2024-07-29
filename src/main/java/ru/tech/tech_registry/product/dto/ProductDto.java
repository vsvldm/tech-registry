package ru.tech.tech_registry.product.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import ru.tech.tech_registry.model.dto.ModelDto;

import javax.validation.constraints.NotNull;
import java.util.List;

public class ProductDto {
    private final Long id;
    @NotNull
    private final String name;
    @NotNull
    private final String country;
    @NotNull
    private final String manufacturer;
    @NotNull
    private final Boolean onlineOrder;
    @NotNull
    private final Boolean installment;
    @JsonManagedReference
    private List<ModelDto> models;

    public ProductDto(Long id,
                      String name,
                      String country,
                      String manufacturer,
                      Boolean onlineOrder,
                      Boolean installment,
                      List<ModelDto> models) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.manufacturer = manufacturer;
        this.onlineOrder = onlineOrder;
        this.installment = installment;
        this.models = models;
    }

    public @NotNull String getName() {
        return name;
    }

    public @NotNull String getCountry() {
        return country;
    }

    public @NotNull String getManufacturer() {
        return manufacturer;
    }

    public @NotNull Boolean getOnlineOrder() {
        return onlineOrder;
    }

    public @NotNull Boolean getInstallment() {
        return installment;
    }

    public List<ModelDto> getModels() {
        return models;
    }

    public void setModels(List<ModelDto> models) {
        this.models = models;
    }

    public Long getId() {
        return id;
    }
}
