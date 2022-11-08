package com.mritech.productservicecqrs.events;

import com.mritech.productservicecqrs.entity.Product;
import com.mritech.productservicecqrs.repo.ProductRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
@ProcessingGroup("product")
public class ProductEventHamdlers {

    private final ProductRepository productRepository;

    public ProductEventHamdlers(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @EventHandler
    public void on(ProductCreatedEvent productCreatedEvent) throws Exception {

        Product product = new Product();
        BeanUtils.copyProperties(productCreatedEvent, product);
        productRepository.save(product);
        throw new Exception("Exception occured!");

    }

    @ExceptionHandler
    public void handle(Exception exception) throws Exception{
         throw exception;
    }
}
