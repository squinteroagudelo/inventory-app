package com.ias.inventory.infraestructure.adapters.inputs.rest.mapper;

import com.ias.inventory.domain.models.Product;
import com.ias.inventory.infraestructure.adapters.inputs.rest.model.request.ProductCreateRequest;
import com.ias.inventory.infraestructure.adapters.inputs.rest.model.response.ProductResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IProductRestMapper {
    Product toProduct(ProductCreateRequest request);
    ProductResponse toProductResponse(Product product);
    List<ProductResponse> toProductResponseList(List<Product> products);
}
