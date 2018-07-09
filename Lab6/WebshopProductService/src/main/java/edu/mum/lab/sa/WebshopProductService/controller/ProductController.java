package edu.mum.lab.sa.WebshopProductService.controller;

import edu.mum.lab.sa.WebshopProductService.event.AddProductEvent;
import edu.mum.lab.sa.WebshopProductService.model.Product;
import edu.mum.lab.sa.WebshopProductService.model.Review;
import edu.mum.lab.sa.WebshopProductService.model.Stock;
import edu.mum.lab.sa.WebshopProductService.model.Supplier;
import edu.mum.lab.sa.WebshopProductService.service.ProductCatalogService;
import edu.mum.lab.sa.WebshopProductService.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductCatalogService productCatalogService;

    @Autowired
    private SupplierService supplierService;



    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping
    public ResponseEntity createProduct(@RequestBody Product product) {
        productCatalogService.addProduct(product.getProductNo(), product.getDescription(), product.getPrice());
        publisher.publishEvent(new AddProductEvent(product));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("{productNo}")
    public ResponseEntity<?> findProductByNo(@PathVariable("productNo") long productNo) {
        Product product = productCatalogService.getProduct(productNo);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping("{productNo}/{supplierId}")
    public ResponseEntity<?> addSupplier(@PathVariable("productNo") long productNo,
                                         @PathVariable("supplierId") long supplierID) {
        Optional<Supplier> supplierOptional = supplierService.findById(supplierID);
        if (!supplierOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Product product = productCatalogService.getProduct(productNo);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        product.setSupplier(supplierOptional.get());
        productCatalogService.updateProduct(product);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("review/{productNo}")
    public ResponseEntity<?> addSupplier(@RequestBody Review review,
                                         @PathVariable("productNo") long productNo) {
        Product product = productCatalogService.getProduct(productNo);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        product.addReview(review);
        productCatalogService.updateProduct(product);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{productNo}/stock")
    public ResponseEntity<?> setProductStock(@RequestBody Stock stock,
                                         @PathVariable("productNo") long productNo) {
        Product product = productCatalogService.getProduct(productNo);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        product.setStock(stock);
        productCatalogService.updateProduct(product);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
