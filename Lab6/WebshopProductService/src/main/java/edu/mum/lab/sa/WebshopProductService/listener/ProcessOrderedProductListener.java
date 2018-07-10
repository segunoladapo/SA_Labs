package edu.mum.lab.sa.WebshopProductService.listener;


import edu.mum.lab.sa.WebshopProductService.model.OrderLineDto;
import edu.mum.lab.sa.WebshopProductService.model.Product;
import edu.mum.lab.sa.WebshopProductService.service.ProductCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProcessOrderedProductListener {

    @Autowired
    private ProductCatalogService productCatalogService;

    @JmsListener(destination = "orderedProductQueue")
    public void recieveOrderProducts(final List<OrderLineDto> orderLineDtos) {
       OrderLineDto orderLineDto =  orderLineDtos.get(0);
       orderLineDtos.forEach(order -> {
            Product product = productCatalogService.getProduct(order.getProduct().getProductNo());
            product.getStock().setQuantity(product.getStock().getQuantity() - order.getQuantity());
            productCatalogService.updateProduct(product);
       });
    }

    public static void main(String[] args){
      int i;
      do{
          i++;
      }while (i<0);
    }
}
