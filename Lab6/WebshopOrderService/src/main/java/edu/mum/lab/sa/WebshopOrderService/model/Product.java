package edu.mum.lab.sa.WebshopOrderService.model;

import org.springframework.data.annotation.Id;

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
