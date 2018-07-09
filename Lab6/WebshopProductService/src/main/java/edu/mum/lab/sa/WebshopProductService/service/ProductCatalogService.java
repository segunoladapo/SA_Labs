package edu.mum.lab.sa.WebshopProductService.service;

import edu.mum.lab.sa.WebshopProductService.dao.ProductRepository;
import edu.mum.lab.sa.WebshopProductService.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCatalogService {
    @Autowired
    private ProductRepository productRepository;

    public void addProduct(long productNo, String description, double price){
        Product product = new Product();
        product.setDescription(description);
        product.setPrice(price);
        product.setProductNo(productNo);
        productRepository.save(product);
    }

    public Product getProduct(long productNo){
        return productRepository.findByProductNo(productNo);
    }

    public void updateProduct(Product product){
        productRepository.save(product);
    }

}
