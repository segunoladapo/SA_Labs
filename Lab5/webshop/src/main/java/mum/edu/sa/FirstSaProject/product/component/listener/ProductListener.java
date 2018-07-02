package mum.edu.sa.FirstSaProject.product.component.listener;

import mum.edu.sa.FirstSaProject.product.component.event.AddProductEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
@EnableAsync
public class ProductListener {

    @Async
    @EventListener
    public void onEvent(AddProductEvent event){
        System.out.println("This Product Name: " + event.getProduct().getDescription() + " was added");
    }
}
