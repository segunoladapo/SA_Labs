package edu.mum.lab.sa.WebshopShoppingCartService.service;


import edu.mum.lab.sa.WebshopShoppingCartService.dao.ShoppingCartRepository;
import edu.mum.lab.sa.WebshopShoppingCartService.model.OrderLine;
import edu.mum.lab.sa.WebshopShoppingCartService.model.Product;
import edu.mum.lab.sa.WebshopShoppingCartService.model.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    @Qualifier("shoppingRestemplate")
    private RestTemplate restTemplate;


    @Value("${product.service.resource.url}")
    private String productServiceResourceUrl;

    @Value("${order.service.resource.url}")
    private String orderServiceResourceUrl;

    public void createShoppingCart(ShoppingCart shoppingCart) {
        shoppingCartRepository.save(shoppingCart);
    }

    public void checkout(long cartId) {

        ShoppingCart shoppingCart = shoppingCartRepository.findById(cartId);
        shoppingCart.checkout();
        ResponseEntity<String> response = restTemplate.postForEntity(orderServiceResourceUrl, shoppingCart, String.class);
        if (response.getStatusCode() != HttpStatus.NO_CONTENT) {
            return;
        }
        shoppingCartRepository.save(shoppingCart);


    }

    public void addOrderLine(OrderLine orderLine, long cartId) {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(cartId);
        shoppingCart.addOrderLine(orderLine);
        shoppingCartRepository.save(shoppingCart);
    }

    public ShoppingCart findById(long cartId) {
        return shoppingCartRepository.findById(cartId);
    }

    public Product getProductById(long id) {
        ResponseEntity<Product> response
                = restTemplate.getForEntity(productServiceResourceUrl + id, Product.class);
        if (response.getStatusCode() != HttpStatus.OK) {
            return null;
        } else {
            return response.getBody();
        }
    }
}
