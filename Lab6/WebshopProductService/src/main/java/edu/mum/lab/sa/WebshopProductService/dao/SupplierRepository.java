package edu.mum.lab.sa.WebshopProductService.dao;


import edu.mum.lab.sa.WebshopProductService.model.Supplier;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SupplierRepository extends MongoRepository<Supplier, Long> {

}
