package edu.mum.lab.sa.WebshopMembership.dao;


import edu.mum.lab.sa.WebshopMembership.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository  extends MongoRepository<Customer, Long> {
}
