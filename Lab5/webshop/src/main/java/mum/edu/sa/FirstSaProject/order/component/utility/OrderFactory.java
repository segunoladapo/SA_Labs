package mum.edu.sa.FirstSaProject.order.component.utility;

import mum.edu.sa.FirstSaProject.order.component.model.Order;
import mum.edu.sa.FirstSaProject.order.component.model.OrderLine;
import mum.edu.sa.FirstSaProject.order.component.model.ShoppingCart;
import org.bson.types.ObjectId;

import java.util.Date;

public class OrderFactory {

    private OrderFactory() {

    }

    public static Order createOrderFromShopping(ShoppingCart shoppingCart) {
        Order order = new Order();
        order.setOrderNumber(ObjectId.getCurrentCounter());
        order.setDate(new Date());
        order.setStatus("PENDING");
        for (OrderLine orderLine : shoppingCart.getOrderLines()) {
            order.addOrderLine(orderLine);
        }
        return order;
    }

}
