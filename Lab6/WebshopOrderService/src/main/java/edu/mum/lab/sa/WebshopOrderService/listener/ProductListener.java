package edu.mum.lab.sa.WebshopOrderService.listener;


import edu.mum.lab.sa.WebshopOrderService.event.AddProductEvent;
import edu.mum.lab.sa.WebshopOrderService.jms.JmsSender;
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
      jmsSender.sendOrderedProductsToQueue(event.getOrderLines());
    }
}
