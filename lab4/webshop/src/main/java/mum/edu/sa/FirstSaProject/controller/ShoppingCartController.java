package mum.edu.sa.FirstSaProject.controller;

import mum.edu.sa.FirstSaProject.model.Order;
import mum.edu.sa.FirstSaProject.model.OrderLine;
import mum.edu.sa.FirstSaProject.model.Product;
import mum.edu.sa.FirstSaProject.model.ShoppingCart;
import mum.edu.sa.FirstSaProject.service.ProductCatalogService;
import mum.edu.sa.FirstSaProject.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shopping")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private ProductCatalogService productCatalogService;

    @PostMapping("/{id}")
    public ResponseEntity startShoppingCart(@PathVariable("id") long id) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(id);
        shoppingCartService.createShoppingCart(shoppingCart);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping("orderline/{id}/{productId}/{quantity}")
    public ResponseEntity addToShoppingCart(@PathVariable("id") long id, @PathVariable("productId") long productId,
                                            @PathVariable("quantity") int quantity) {

        Product product = productCatalogService.getProduct(productId);
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
