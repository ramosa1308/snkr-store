package com.snkrstore.product.services;

import com.snkrstore.product.web.model.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto getProductById(String ticker);

    ProductDto saveProduct(ProductDto productDto);

    ProductDto updateProduct(ProductDto productDto);

    void deleteProduct(String ticker);

    List<ProductDto> getAllProducts();

    List<ProductDto> getProductByFilter(String filter);
}
