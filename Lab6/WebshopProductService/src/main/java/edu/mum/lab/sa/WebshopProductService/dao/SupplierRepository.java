package edu.mum.lab.sa.WebshopProductService.dao;

import mum.edu.sa.FirstSaProject.product.component.model.Supplier;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SupplierRepository extends MongoRepository<Supplier, Long> {

}
