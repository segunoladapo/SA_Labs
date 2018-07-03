package edu.mum.lab.sa.WebshopShoppingCartService.dao;

import edu.mum.lab.sa.WebshopShoppingCartService.model.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, Long> {
    ShoppingCart findById(long id);
}
