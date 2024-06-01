package com.ias.inventory.application.ports.inputs;

import com.ias.inventory.domain.models.Product;

import java.util.List;

public interface IProductServicePort {
    Product findProductById(Long id);
    List<Product> findAllProducts();
    Product saveProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteById(Long id);
}
