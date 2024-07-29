package ru.tech.tech_registry.smartphone.model;

import ru.tech.tech_registry.model.model.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "smartphones")
public class Smartphone extends Model {
    private Integer memory;
    private Integer cameras;

    public Smartphone() {
    }

    public Smartphone(Integer memory, Integer cameras) {
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
        if (!(o instanceof Smartphone)) return false;
        Smartphone that = (Smartphone) o;
        return Objects.equals(memory, that.memory) && Objects.equals(cameras, that.cameras);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memory, cameras);
    }
}
