package mum.edu.sa.FirstSaProject.order.component.model;

import mum.edu.sa.FirstSaProject.product.component.model.Review;
import mum.edu.sa.FirstSaProject.product.component.model.Stock;
import mum.edu.sa.FirstSaProject.product.component.model.Supplier;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

public class Product {
    @Id
    private long productNo;
    private String description;
    private double price;

    public long getProductNo() {
        return productNo;
    }

    public void setProductNo(long productNo) {
        this.productNo = productNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
