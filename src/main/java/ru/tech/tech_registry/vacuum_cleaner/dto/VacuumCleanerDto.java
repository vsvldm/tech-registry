package ru.tech.tech_registry.vacuum_cleaner.dto;

import ru.tech.tech_registry.model.dto.ModelDto;
import ru.tech.tech_registry.product.dto.ProductDto;

import java.util.Objects;

public class VacuumCleanerDto extends ModelDto {
    private Double dustCollectorVolume;
    private Integer modes;

    public VacuumCleanerDto(Long id,
                            String name,
                            String serialNumber,
                            String color,
                            String size,
                            Double price,
                            Boolean inStock,
                            ProductDto productDto,
                            Double dustCollectorVolume,
                            Integer modes) {
        super(id,
                name,
                serialNumber,
                color,
                size,
                price,
                inStock,
                productDto);
        this.dustCollectorVolume = dustCollectorVolume;
        this.modes = modes;
    }

    public void setDustCollectorVolume(Double dustCollectorVolume) {
        this.dustCollectorVolume = dustCollectorVolume;
    }

    public void setModes(Integer modes) {
        this.modes = modes;
    }

    public Double getDustCollectorVolume() {
        return dustCollectorVolume;
    }

    public Integer getModes() {
        return modes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VacuumCleanerDto)) return false;
        if (!super.equals(o)) return false;
        VacuumCleanerDto that = (VacuumCleanerDto) o;
        return Objects.equals(dustCollectorVolume, that.dustCollectorVolume) && Objects.equals(modes, that.modes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dustCollectorVolume, modes);
    }
}
