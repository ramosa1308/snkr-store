package com.snkrstore.product.repository;

import com.snkrstore.product.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findAllByBrandContainingOrSubBrandContainingOrDetailContaining(String filter, String filter2, String filter3);
}
