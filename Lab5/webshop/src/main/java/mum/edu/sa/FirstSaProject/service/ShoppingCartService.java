package mum.edu.sa.FirstSaProject.service;

import mum.edu.sa.FirstSaProject.dao.ShoppingCartRepository;
import mum.edu.sa.FirstSaProject.model.OrderLine;
import mum.edu.sa.FirstSaProject.model.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private OrderService orderService;

    public void createShoppingCart(ShoppingCart shoppingCart) {
        shoppingCartRepository.save(shoppingCart);
    }

    public void checkout(long cartId) {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(cartId);
        shoppingCart.checkout();
        shoppingCartRepository.save(shoppingCart);
        orderService.createOrder(cartId, shoppingCart);
    }

    public void addOrderLine(OrderLine orderLine, long cartId) {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(cartId);
        shoppingCart.addOrderLine(orderLine);
        shoppingCartRepository.save(shoppingCart);
    }

    public ShoppingCart findById(long cartId) {
        return shoppingCartRepository.findById(cartId);
    }

}
