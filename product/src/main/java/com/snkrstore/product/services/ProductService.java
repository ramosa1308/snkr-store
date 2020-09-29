package com.snkrstore.product.services;

import com.snkrstore.product.web.model.ProductDto;

import java.util.UUID;

public interface ProductService {
    ProductDto getProductById(UUID productId);

    ProductDto saveProductDto(ProductDto productDto);
}
