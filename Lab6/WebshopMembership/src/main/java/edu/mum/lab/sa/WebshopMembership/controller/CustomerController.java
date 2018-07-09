package edu.mum.lab.sa.WebshopMembership.controller;

import edu.mum.lab.sa.WebshopMembership.model.Account;
import edu.mum.lab.sa.WebshopMembership.model.CreditCard;
import edu.mum.lab.sa.WebshopMembership.model.Customer;
import edu.mum.lab.sa.WebshopMembership.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/membership")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findCustomerById(@PathVariable("id") long id) {
        Optional<Customer> customer = customerService.findCustomerById(id);
        if (customer.isPresent()) {
            return new ResponseEntity<>(customer.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("account/{customerId}")
    public ResponseEntity<?> addAccount(@RequestBody Account account,
                                        @PathVariable("customerId") long customerId) {
        Optional<Customer> customerOptional = customerService.findCustomerById(customerId);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Customer customer = customerOptional.get();
        customer.setAccount(account);
        customerService.updateCustomer(customer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("creditcard/{customerId}")
    public ResponseEntity<?> addCreditCart(@RequestBody CreditCard creditCard,
                                           @PathVariable("customerId") long customerId) {
        Optional<Customer> customerOptional = customerService.findCustomerById(customerId);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Customer customer = customerOptional.get();
        customer.addCreditCard(creditCard);
        customerService.updateCustomer(customer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}