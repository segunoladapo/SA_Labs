package edu.mum.lab.sa.WebshopProductService.listener;


import edu.mum.lab.sa.WebshopProductService.model.OrderLineDto;
import edu.mum.lab.sa.WebshopProductService.model.Product;
import edu.mum.lab.sa.WebshopProductService.service.ProductCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;

import java.util.List;


public class ProcessOrderedProductListener {

    @Autowired
    private ProductCatalogService productCatalogService;

    @JmsListener(destination = "orderedProductQueue")
    public void recieveOrderProducts(final List<OrderLineDto> orderLineDtos) {
        orderLineDtos.forEach(order -> {
            Product product = productCatalogService.getProduct(order.getProduct().getProductNo());
            product.getStock().setQuantity(product.getStock().getQuantity() - order.getQuantity());
            productCatalogService.updateProduct(product);
        });
    }
}
