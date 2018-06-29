package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private long orderNumber;
    private Date date;
    private String status;
    private boolean confirm;
    private List<OrderLine> orderLineList;

    public Order() {
        orderLineList = new ArrayList<>();
    }

    public void addOrderLine(OrderLine orderLine) {
        orderLineList.add(orderLine);
    }


    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }
}
