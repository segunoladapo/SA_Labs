package edu.mum.sa.lab.SpringIntegration.service;

import edu.mum.sa.lab.SpringIntegration.model.Order;
import org.springframework.stereotype.Service;

public class WareHouseService {

    public void processOrder(Order order){
        System.out.println("Order number: " + order.getOrderNo() + " has been received into the warehouse");
    }
}
