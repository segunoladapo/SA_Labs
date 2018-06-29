package mum.edu.sa.FirstSaProject.model;

import com.sun.javafx.UnmodifiableArrayList;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Document(collection = "shoppingCart")
public class ShoppingCart {
    @Id
    private long id;
    private List<OrderLine> orderLines;
    private boolean isCheckedOut;

    public ShoppingCart() {
        orderLines = new ArrayList<>();
    }

    public void addOrderLine(OrderLine orderLine) {
        orderLines.add(orderLine);
    }

    public List<OrderLine> getOrderLines(){
        return Collections.unmodifiableList(orderLines);
    }

    public void removeFromCart(OrderLine orderLine) {
        orderLines.remove(orderLine);
    }

    public synchronized void checkout() {
        isCheckedOut = true;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
