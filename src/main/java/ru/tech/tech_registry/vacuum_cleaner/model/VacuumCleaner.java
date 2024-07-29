package ru.tech.tech_registry.vacuum_cleaner.model;

import ru.tech.tech_registry.model.model.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "vacuum_cleaners")
public class VacuumCleaner extends Model {
    private Double dustCollectorVolume;
    private Integer modes;

    public VacuumCleaner() {
    }

    public VacuumCleaner(Double dustCollectorVolume, Integer modes) {
        this.dustCollectorVolume = dustCollectorVolume;
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
        if (!(o instanceof VacuumCleaner)) return false;
        VacuumCleaner that = (VacuumCleaner) o;
        return Objects.equals(dustCollectorVolume, that.dustCollectorVolume) && Objects.equals(modes, that.modes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dustCollectorVolume, modes);
    }
}
