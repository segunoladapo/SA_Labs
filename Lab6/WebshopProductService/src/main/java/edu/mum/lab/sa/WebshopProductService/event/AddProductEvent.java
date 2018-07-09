package edu.mum.lab.sa.WebshopProductService.event;


import edu.mum.lab.sa.WebshopProductService.model.Product;

import java.util.Collections;
import java.util.List;

public class AddProductEvent {

    public AddProductEvent(Product product){
        this.product = product;
    }

    private Product product;
    public Product getProduct(){
        return this.product;
    }
}
