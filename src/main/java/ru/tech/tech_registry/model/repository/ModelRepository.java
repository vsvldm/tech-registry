package ru.tech.tech_registry.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.tech.tech_registry.model.model.Model;
import ru.tech.tech_registry.product.model.Product;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Long>, JpaSpecificationExecutor<Model> {
    List<Model> findAllByProduct(Product product);
}
