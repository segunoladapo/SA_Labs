package mum.edu.sa.FirstSaProject.product.component.controller;


import mum.edu.sa.FirstSaProject.product.component.model.Supplier;
import mum.edu.sa.FirstSaProject.product.component.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping
    public ResponseEntity addSupplier(@RequestBody Supplier supplier) {
        supplierService.addSupplier(supplier);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable("id") long id) {
        Optional<Supplier> supplier = supplierService.findById(id);
        if (supplier.isPresent() == true) {
            return new ResponseEntity<>(supplier.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
