package mum.edu.sa.FirstSaProject.dao;

import mum.edu.sa.FirstSaProject.model.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShoppingCartRepository  extends MongoRepository<ShoppingCart, Long> {

}
