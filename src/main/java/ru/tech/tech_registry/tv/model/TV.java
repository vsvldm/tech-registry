package ru.tech.tech_registry.tv.model;

import ru.tech.tech_registry.model.model.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tvs")
public class TV extends Model {
    private String category;
    private String technology;

    public TV() {
    }

    public TV(String category, String technology) {
        this.category = category;
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
        if (!(o instanceof TV)) return false;
        TV tv = (TV) o;
        return Objects.equals(category, tv.category) && Objects.equals(technology, tv.technology);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, technology);
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }
}
