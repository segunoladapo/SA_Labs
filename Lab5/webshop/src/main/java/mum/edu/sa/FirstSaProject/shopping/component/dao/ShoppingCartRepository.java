package mum.edu.sa.FirstSaProject.shopping.component.dao;

import mum.edu.sa.FirstSaProject.shopping.component.model.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, Long> {
    ShoppingCart findById(long id);
}
