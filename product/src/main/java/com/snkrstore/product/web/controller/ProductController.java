package com.snkrstore.product.web.controller;

import com.snkrstore.product.domain.Product;
import com.snkrstore.product.services.ProductService;
import com.snkrstore.product.web.model.ProductDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping({"/{ticker}"})
    public ResponseEntity<ProductDto> getProduct(@PathVariable("ticker") String ticker){
        return new ResponseEntity<ProductDto>(productService.getProductById(ticker), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        return new ResponseEntity<List<ProductDto>>(productService.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewProduct(@Valid @RequestBody ProductDto product){
        ProductDto savedProduct = productService.saveProduct(product);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/product/" + savedProduct.getTicker());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Product> updateProductById(@Valid @RequestBody ProductDto product){
        ProductDto updatedProduct = productService.updateProduct(product);
        return new ResponseEntity(updatedProduct,HttpStatus.OK);
    }

    @DeleteMapping({"/{ticker}"})
    public ResponseEntity<ProductDto> deleteProduct(@PathVariable("ticker") String ticker){
        productService.deleteProduct(ticker);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<ProductDto>> getProductByFilter(@RequestParam("filter") String filter){
        return new ResponseEntity<>(productService.getProductByFilter(filter), HttpStatus.OK);
    }

}
