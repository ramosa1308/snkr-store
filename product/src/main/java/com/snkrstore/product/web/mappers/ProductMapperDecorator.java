package com.snkrstore.product.web.mappers;

import com.snkrstore.product.domain.Product;
import com.snkrstore.product.web.model.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class ProductMapperDecorator implements ProductMapper{
    private ProductMapper mapper;

    @Autowired
    public void setMapper(ProductMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public ProductDto productToProductDto(Product product) {
        return mapper.productToProductDto(product);
    }

    @Override
    public Product productDtoToProduct(ProductDto productDto) {
        return mapper.productDtoToProduct(productDto);
    }

    @Override
    public List<ProductDto> productListToProductDtoList(List<Product> productList) {
        return mapper.productListToProductDtoList(productList);
    }
}
