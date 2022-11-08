package com.mritech.productservicecqrs;

import com.mritech.productservicecqrs.exception.ProductServiceEventsErrorHandler;
import org.axonframework.config.EventProcessingConfiguration;
import org.axonframework.config.EventProcessingConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceCqrsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceCqrsApplication.class, args);
    }

    @Autowired
    public void configure(EventProcessingConfigurer eventProcessingConfigurer) {
        eventProcessingConfigurer.registerListenerInvocationErrorHandler(
                "product",
                configuration -> new ProductServiceEventsErrorHandler()
        );
    }

}
