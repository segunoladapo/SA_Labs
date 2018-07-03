package edu.mum.lab.sa.WebshopProductService.dao;

import mum.edu.sa.FirstSaProject.product.component.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProductRepository extends MongoRepository<Product, Long> {
    Product findByProductNo(long productNo);
}
