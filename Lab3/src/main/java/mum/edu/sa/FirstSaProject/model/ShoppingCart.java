package mum.edu.sa.FirstSaProject.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "shoppingCart")
public class ShoppingCart {
    @Id
    private long id;
    private List<Product> productList;

    public ShoppingCart(){
        productList = new ArrayList<>();
    }

    public List<Product> getProductList() {
        return productList;
    }

}
