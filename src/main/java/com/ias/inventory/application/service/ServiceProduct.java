package com.ias.inventory.application.service;

import com.ias.inventory.application.ports.inputs.IProductServicePort;
import com.ias.inventory.application.ports.outputs.IProductPersistencePort;
import com.ias.inventory.domain.exception.ProductNotFoundException;
import com.ias.inventory.domain.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceProduct implements IProductServicePort {

    private final IProductPersistencePort productPersistencePort;

    @Override
    public Product findProductById(Long id) throws ProductNotFoundException {
        return productPersistencePort.findById(id)
                .orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public List<Product> findAllProducts() {
        return productPersistencePort.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return productPersistencePort.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) throws ProductNotFoundException {
        return productPersistencePort
                .findById(id)
                .map(p -> {
                    p.setName(product.getName());
                    p.setPrecio(product.getPrecio());
                    return productPersistencePort.save(p);
                })
                .orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) throws ProductNotFoundException {
        if(productPersistencePort.findById(id).isEmpty())
            throw new ProductNotFoundException();

        productPersistencePort.deleteById(id);
    }
}
