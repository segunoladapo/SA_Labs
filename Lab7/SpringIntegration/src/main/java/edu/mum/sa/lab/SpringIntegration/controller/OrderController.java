package edu.mum.sa.lab.SpringIntegration.controller;

import edu.mum.sa.lab.SpringIntegration.model.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @PostMapping
    public ResponseEntity processOrder(@RequestBody Order order) {
        return new ResponseEntity(HttpStatus.OK);
    }
}
