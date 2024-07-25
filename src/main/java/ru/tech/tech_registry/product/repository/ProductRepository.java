package ru.tech.tech_registry.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tech.tech_registry.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
