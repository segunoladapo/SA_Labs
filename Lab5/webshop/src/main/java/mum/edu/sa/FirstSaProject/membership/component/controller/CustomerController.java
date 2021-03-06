package mum.edu.sa.FirstSaProject.membership.component.controller;

import mum.edu.sa.FirstSaProject.membership.component.model.Account;
import mum.edu.sa.FirstSaProject.membership.component.model.CreditCard;
import mum.edu.sa.FirstSaProject.membership.component.model.Customer;
import mum.edu.sa.FirstSaProject.membership.component.service.CustomerService;
import mum.edu.sa.FirstSaProject.product.component.model.Product;
import mum.edu.sa.FirstSaProject.product.component.model.Supplier;
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