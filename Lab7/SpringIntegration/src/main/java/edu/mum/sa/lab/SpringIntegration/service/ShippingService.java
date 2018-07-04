package edu.mum.sa.lab.SpringIntegration.service;

import edu.mum.sa.lab.SpringIntegration.model.Order;

public class ShippingService {

    public void processOrder(Order order){
        System.out.println("Order no: " + order.getOrderNo() + " has been received for shipping");
    }
}
