package mum.edu.sa.FirstSaProject.membership.component.service;

import mum.edu.sa.FirstSaProject.membership.component.dao.CustomerRepository;
import mum.edu.sa.FirstSaProject.membership.component.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public void updateCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public Optional<Customer> findCustomerById(long id){
        return customerRepository.findById(id);
    }
}
