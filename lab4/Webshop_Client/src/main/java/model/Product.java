package model;

public class Product {
    private long productNo;
    private String description;
    private double price;
    private Stock stock;

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

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
