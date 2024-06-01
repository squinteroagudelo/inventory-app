package com.ias.inventory.infraestructure.adapters.inputs.rest;

import com.ias.inventory.application.ports.inputs.IProductServicePort;
import com.ias.inventory.infraestructure.adapters.inputs.rest.mapper.IProductRestMapper;
import com.ias.inventory.infraestructure.adapters.inputs.rest.model.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductRestAdapter {

    private final IProductServicePort productServicePort;
    private final IProductRestMapper mapper;

    @GetMapping("/api")
    public List<ProductResponse> findAll(){
        return mapper.toProductResponseList(productServicePort.findAllProducts());
    }
}
