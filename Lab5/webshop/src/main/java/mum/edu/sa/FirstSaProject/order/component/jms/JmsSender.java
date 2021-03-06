package mum.edu.sa.FirstSaProject.order.component.jms;
import mum.edu.sa.FirstSaProject.order.component.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JmsSender {
    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendJmsMessage(Product product){
        jmsTemplate.convertAndSend("jmsQueue",product);
    }

    public void sendOrderedProductsToQueue(List<Product>products){
        products.forEach(product -> jmsTemplate.convertAndSend("orderedProductQueue", product));
    }
}
