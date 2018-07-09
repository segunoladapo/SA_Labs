package edu.mum.lab.sa.WebshopProductService.service;

import edu.mum.lab.sa.WebshopProductService.dao.SupplierRepository;
import edu.mum.lab.sa.WebshopProductService.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public void addSupplier(Supplier supplier){
        supplierRepository.save(supplier);
    }

    public Optional<Supplier> findById(long id){
        return supplierRepository.findById(id);
    }
}
