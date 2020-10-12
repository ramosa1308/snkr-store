package com.snkrstore.product.web.mappers;

import com.snkrstore.product.domain.Product;
import com.snkrstore.product.web.model.ProductDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
@DecoratedWith(ProductMapperDecorator.class)
public interface ProductMapper {
    ProductDto productToProductDto(Product product);
    Product productDtoToProduct(ProductDto productDto);
    List<ProductDto> productListToProductDtoList(List<Product> productList);
}
