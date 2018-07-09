package edu.mum.lab.sa.WebshopOrderService.event;


import edu.mum.lab.sa.WebshopOrderService.model.OrderLine;
import edu.mum.lab.sa.WebshopOrderService.model.Product;

import java.util.Collections;
import java.util.List;

public class AddProductEvent {

    public AddProductEvent(List<OrderLine> orderLines){
        this.OrderLines = OrderLines;
    }

    private List<OrderLine> OrderLines;
    public List<OrderLine> getProducts(){
        return Collections.unmodifiableList(OrderLines);
    }
}
