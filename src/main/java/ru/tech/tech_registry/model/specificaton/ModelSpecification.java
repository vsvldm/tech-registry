package ru.tech.tech_registry.model.specificaton;

import org.springframework.data.jpa.domain.Specification;
import ru.tech.tech_registry.model.model.Model;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class ModelSpecification {

    public static Specification<Model> hasName(String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }

    public static Specification<Model> hasColor(String color) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("color"), color);
    }

    public static Specification<Model> hasPriceBetween(Double minPrice, Double maxPrice) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("price"), minPrice, maxPrice);
    }

    public static Specification<Model> hasType(Class<? extends Model> type) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.type(), type);
    }
}
