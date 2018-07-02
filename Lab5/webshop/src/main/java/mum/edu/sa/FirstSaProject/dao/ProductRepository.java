package mum.edu.sa.FirstSaProject.dao;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProductRepository  extends MongoRepository<Product, Long> {
    Product findByProductNo(long productNo);
}
