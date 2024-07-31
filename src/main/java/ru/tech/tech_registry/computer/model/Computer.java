package ru.tech.tech_registry.computer.model;

import ru.tech.tech_registry.model.model.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "computers")
public class Computer extends Model {
    private String category;
    private String processorType;

    public Computer() {
    }

    public Computer(String category, String processorType) {
        this.category = category;
        this.processorType = processorType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProcessorType() {
        return processorType;
    }

    
    public void setProcessorType(String processorType) {
        this.processorType = processorType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Computer)) return false;
        Computer computer = (Computer) o;
        return Objects.equals(category, computer.category) && Objects.equals(processorType, computer.processorType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, processorType);
    }
}
