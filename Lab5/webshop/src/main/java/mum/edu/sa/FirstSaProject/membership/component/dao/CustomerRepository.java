package mum.edu.sa.FirstSaProject.membership.component.dao;

import mum.edu.sa.FirstSaProject.membership.component.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository  extends MongoRepository<Customer, Long> {
}
