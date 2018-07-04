package edu.mum.sa.lab.SpringIntegration.integration;

import edu.mum.sa.lab.SpringIntegration.model.Order;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway
public interface OrderGateway {
    @Gateway(requestChannel = "inputChannel")
    Order handleRequest(Order order);
}
