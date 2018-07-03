package edu.mum.lab.sa.WebshopShoppingCartService.controller;

import edu.mum.lab.sa.WebshopShoppingCartService.model.OrderLine;
import edu.mum.lab.sa.WebshopShoppingCartService.model.Product;
import edu.mum.lab.sa.WebshopShoppingCartService.model.ShoppingCart;
import edu.mum.lab.sa.WebshopShoppingCartService.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;


    @PostMapping("/{id}")
    public ResponseEntity createShoppingCart(@PathVariable("id") long id) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(id);
        shoppingCartService.createShoppingCart(shoppingCart);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping("orderline/{id}/{productId}/{quantity}")
    public ResponseEntity addToShoppingCart(@PathVariable("id") long id, @PathVariable("productId") long productId,
                                            @PathVariable("quantity") int quantity) {

        Product product = shoppingCartService.getProductById(productId);
        OrderLine orderLine = new OrderLine();
        orderLine.setProduct(product);
        orderLine.setQuantity(quantity);
        shoppingCartService.addOrderLine(orderLine, id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping("checkout/{id}")
    public ResponseEntity checkoutCart(@PathVariable("id") long id) {
        shoppingCartService.checkout(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
