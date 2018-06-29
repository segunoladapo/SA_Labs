package mum.edu.sa.FirstSaProject.service;

import mum.edu.sa.FirstSaProject.dao.OrderRepository;
import mum.edu.sa.FirstSaProject.model.Order;
import mum.edu.sa.FirstSaProject.model.OrderLine;
import mum.edu.sa.FirstSaProject.model.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public void createOrder(long id, ShoppingCart shoppingCart) {
        Order order = new Order();
        order.setOrderNumber(id);
        order.setDate(new Date());
        order.setConfirm(true);
        order.setStatus("PENDING");
        for (OrderLine orderLine : shoppingCart.getOrderLines()) {
            order.addOrderLine(orderLine);
        }
        orderRepository.save(order);
    }

    public Order getOrder(long orderNo){
        return orderRepository.findByOrderNumber(orderNo);
    }
}
