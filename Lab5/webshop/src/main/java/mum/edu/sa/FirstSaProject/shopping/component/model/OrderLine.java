package mum.edu.sa.FirstSaProject.shopping.component.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orderlines")
public class OrderLine {
    private Product product;
    private int quantity;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
