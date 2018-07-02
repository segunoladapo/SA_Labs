package mum.edu.sa.FirstSaProject.product.component.event;

import mum.edu.sa.FirstSaProject.product.component.model.Product;

public class AddProductEvent {
    private Product product;

    public AddProductEvent(Product product){
        this.product = product;
    }

    public Product getProduct(){
        return product;
    }
}
