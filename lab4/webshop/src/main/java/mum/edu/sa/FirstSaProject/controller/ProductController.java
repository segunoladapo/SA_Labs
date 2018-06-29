package mum.edu.sa.FirstSaProject.controller;

import mum.edu.sa.FirstSaProject.model.Product;
import mum.edu.sa.FirstSaProject.service.ProductCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductCatalogService productCatalogService;

    @PostMapping
    public ResponseEntity createProduct(@RequestBody Product product) {
        productCatalogService.addProduct(product.getProductNo(), product.getDescription(), product.getPrice());
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
}
