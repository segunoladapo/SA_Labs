package mum.edu.sa.FirstSaProject.order.component.listener;

import mum.edu.sa.FirstSaProject.order.component.event.AddProductEvent;
import mum.edu.sa.FirstSaProject.order.component.jms.JmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service("orderProductListener")
@EnableAsync
public class ProductListener {
    @Autowired
    private JmsSender jmsSender;

    @Async
    @EventListener
    public void onEvent(AddProductEvent event){
      jmsSender.sendOrderedProductsToQueue(event.getProducts());
    }
}
