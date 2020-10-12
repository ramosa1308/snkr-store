package com.snkrstore.product.services;

import com.snkrstore.product.domain.Product;
import com.snkrstore.product.repository.ProductRepository;
import com.snkrstore.product.web.mappers.ProductMapper;
import com.snkrstore.product.web.model.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDto getProductById(String ticker) {
        Optional<Product> optionalProduct = productRepository.findById(ticker);
        Product product = new Product();
        if(optionalProduct.isPresent()){
            product = optionalProduct.get();
        }

        return productMapper.productToProductDto(product);
    }

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        Product product = productMapper.productDtoToProduct(productDto);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("FECHA: HORA - " + localDateTime);
        product.setCreatedDate(localDateTime);
        product.setLastModifiedDate(localDateTime);
        product = productRepository.save(product);
        productDto = productMapper.productToProductDto(product);
        return productDto;
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        Product product = productMapper.productDtoToProduct(productDto);
        LocalDateTime localDateTime = LocalDateTime.now();
        product.setLastModifiedDate(localDateTime);
        product = productRepository.save(product);
        productDto = productMapper.productToProductDto(product);
        return productDto;
    }

    @Override
    public void deleteProduct(String ticker) {
        productRepository.deleteById(ticker);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtoList = productMapper.productListToProductDtoList(products);
         return productDtoList;
    }

    @Override
    public List<ProductDto> getProductByFilter(String filter) {
        List<Product> products = productRepository.findAllByBrandContainingOrSubBrandContainingOrDetailContaining(filter,filter,filter);
        return productMapper.productListToProductDtoList(products);
    }
}
