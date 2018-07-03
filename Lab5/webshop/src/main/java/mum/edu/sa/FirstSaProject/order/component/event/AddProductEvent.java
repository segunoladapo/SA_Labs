package mum.edu.sa.FirstSaProject.order.component.event;

import mum.edu.sa.FirstSaProject.order.component.model.Product;
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
