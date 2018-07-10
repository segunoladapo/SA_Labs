package edu.mum.lab.sa.WebshopOrderService.jms;


import edu.mum.lab.sa.WebshopOrderService.model.OrderLine;
import edu.mum.lab.sa.WebshopOrderService.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JmsSender {
    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendJmsMessage(Product product) {
        jmsTemplate.convertAndSend("jmsQueue", product);
    }

    public void sendOrderedProductsToQueue(List<OrderLine> orderLines) {
      jmsTemplate.convertAndSend("orderedProductQueue", orderLines);
    }
}
