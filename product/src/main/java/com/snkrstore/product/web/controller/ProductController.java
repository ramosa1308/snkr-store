package com.snkrstore.product.web.controller;

import com.snkrstore.product.services.ProductService;
import com.snkrstore.product.web.model.ProductDto;
import com.snkrstore.product.services.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping({"/{productId}"})
    public ResponseEntity<ProductDto> getProduct(@PathVariable("productId") UUID productId){

        return new ResponseEntity<>(productService.getProductById(productId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody ProductDto productDto){
        ProductDto savedProductDto = productService.saveProductDto(productDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/product/" + savedProductDto.getId());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }
}
