package com.ias.inventory.application.ports.outputs;

import com.ias.inventory.domain.models.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface IProductPersistencePort {
    Optional<Product> findById(Long id);
    List<Product> findAll();
    Product save(Product product);
    void deleteById(Long id);
}
