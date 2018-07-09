package edu.mum.lab.sa.WebshopOrderService.controller;

import edu.mum.lab.sa.WebshopOrderService.event.AddProductEvent;
import edu.mum.lab.sa.WebshopOrderService.model.*;
import edu.mum.lab.sa.WebshopOrderService.service.OrderService;
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
        publisher.publishEvent(new AddProductEvent(order.getOrderLineList()));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
