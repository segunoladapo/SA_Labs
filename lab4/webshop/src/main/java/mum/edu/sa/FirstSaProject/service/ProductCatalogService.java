package mum.edu.sa.FirstSaProject.service;

import mum.edu.sa.FirstSaProject.dao.ProductRepository;
import mum.edu.sa.FirstSaProject.model.Product;
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


}
