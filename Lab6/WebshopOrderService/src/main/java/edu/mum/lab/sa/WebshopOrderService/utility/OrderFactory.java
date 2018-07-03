package edu.mum.lab.sa.WebshopOrderService.utility;

import edu.mum.lab.sa.WebshopOrderService.model.Order;
import edu.mum.lab.sa.WebshopOrderService.model.OrderLine;
import edu.mum.lab.sa.WebshopOrderService.model.ShoppingCart;
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
