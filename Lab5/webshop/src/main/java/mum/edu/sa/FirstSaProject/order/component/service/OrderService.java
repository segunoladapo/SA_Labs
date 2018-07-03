package mum.edu.sa.FirstSaProject.order.component.service;

import mum.edu.sa.FirstSaProject.order.component.dao.OrderRepository;
import mum.edu.sa.FirstSaProject.order.component.model.*;
import mum.edu.sa.FirstSaProject.order.component.utility.OrderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    @Autowired
    @Qualifier("orderRestTemplate")
    private RestTemplate restTemplate;

    @Value("${customer.service.resource.url}")
    private String customerServiceResourceUrl;


    public void createOrder(ShoppingCart shoppingCart) {
        orderRepository.save(OrderFactory.createOrderFromShopping(shoppingCart));
    }

    public Order getOrder(long orderNo) {
        return orderRepository.findByOrderNumber(orderNo);
    }

    public void confirmOrder(Order order, Customer customer, CreditCard creditCard) {
        order.setCustomer(customer);
        order.setCreditCard(creditCard);
        order.setAddress(customer.getAddress());
        order.setConfirm(true);
        orderRepository.save(order);
    }

    public Order findByOrderNumber(long id) {
        return orderRepository.findByOrderNumber(id);
    }

    public Customer findCustomerById(long id) {
        ResponseEntity<Customer> response
                = restTemplate.getForEntity(customerServiceResourceUrl + id, Customer.class);
        if (response.getStatusCode() != HttpStatus.OK) {
            return null;
        } else {
            return response.getBody();
        }
    }

}
