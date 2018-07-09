package edu.mum.lab.sa.WebshopProductService.dao;


import edu.mum.lab.sa.WebshopProductService.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, Long> {
    Product findByProductNo(long productNo);
}
