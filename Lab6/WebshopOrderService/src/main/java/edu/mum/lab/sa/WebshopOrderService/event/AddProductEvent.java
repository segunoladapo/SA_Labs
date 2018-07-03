package edu.mum.lab.sa.WebshopOrderService.event;


import edu.mum.lab.sa.WebshopOrderService.model.Product;

import java.util.Collections;
import java.util.List;

public class AddProductEvent {

    public AddProductEvent(List<Product> products){
        this.products = products;
    }

    private List<Product> products;
    public List<Product> getProducts(){
        return Collections.unmodifiableList(products);
    }
}
