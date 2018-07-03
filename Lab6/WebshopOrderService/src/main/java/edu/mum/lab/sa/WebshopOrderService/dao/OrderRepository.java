package edu.mum.lab.sa.WebshopOrderService.dao;


import edu.mum.lab.sa.WebshopOrderService.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, Long> {
    Order findByOrderNumber(long orderNumber);
}
