package ru.tech.tech_registry.refrigerator.model;

import ru.tech.tech_registry.model.model.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "refrigerators")
public class Refrigerator extends Model {
    private Integer doorCount;
    private String compressorType;

    public Refrigerator() {
    }

    public Refrigerator(Integer doorCount, String compressorType) {
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
        if (!(o instanceof Refrigerator)) return false;
        Refrigerator that = (Refrigerator) o;
        return Objects.equals(doorCount, that.doorCount) && Objects.equals(compressorType, that.compressorType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doorCount, compressorType);
    }
}
