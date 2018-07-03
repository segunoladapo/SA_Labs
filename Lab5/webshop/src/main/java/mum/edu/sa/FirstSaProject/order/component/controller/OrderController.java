package mum.edu.sa.FirstSaProject.order.component.controller;

import mum.edu.sa.FirstSaProject.order.component.event.AddProductEvent;
import mum.edu.sa.FirstSaProject.order.component.model.*;
import mum.edu.sa.FirstSaProject.order.component.model.Customer;
import mum.edu.sa.FirstSaProject.order.component.model.Order;
import mum.edu.sa.FirstSaProject.order.component.model.ShoppingCart;
import mum.edu.sa.FirstSaProject.order.component.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping
    public ResponseEntity createOrder(@RequestBody ShoppingCart shoppingCart) {
        orderService.createOrder(shoppingCart);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    @PostMapping("/{id}/customer/{customerId}")
    public ResponseEntity confirmOrder(@RequestBody CreditCard creditCard, @PathVariable("id") long id, @PathVariable("customerId") long customerId) {
        Customer customer = orderService.findCustomerById(customerId);
        if (customer == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        Order order = orderService.findByOrderNumber(id);
        if (order == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        orderService.confirmOrder(order, customer, creditCard);
        List<Product> products = order.getOrderLineList()
                .stream()
                .map(e -> e.getProduct())
                .collect(Collectors.toList());
        publisher.publishEvent(new AddProductEvent(products));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
