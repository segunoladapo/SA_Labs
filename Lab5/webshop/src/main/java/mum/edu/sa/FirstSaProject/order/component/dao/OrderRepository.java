package mum.edu.sa.FirstSaProject.order.component.dao;

import mum.edu.sa.FirstSaProject.order.component.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, Long> {
    Order findByOrderNumber(long orderNumber);
}
