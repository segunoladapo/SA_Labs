package mum.edu.sa.FirstSaProject.dao;

import mum.edu.sa.FirstSaProject.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProductRepository  extends MongoRepository<Product, Long> {
    Product findByProductNo(long productNo);
}
