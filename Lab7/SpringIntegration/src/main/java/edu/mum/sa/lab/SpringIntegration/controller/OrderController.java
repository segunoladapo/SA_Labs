package edu.mum.sa.lab.SpringIntegration.controller;

import edu.mum.sa.lab.SpringIntegration.integration.OrderGateway;
import edu.mum.sa.lab.SpringIntegration.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.annotation.Gateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderGateway orderGateway;

    @PostMapping
    public ResponseEntity processOrder(@RequestBody Order order) {
        orderGateway.handleRequest(order);
        return new ResponseEntity(HttpStatus.OK);
    }
}
