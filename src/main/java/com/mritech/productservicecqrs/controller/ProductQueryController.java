package com.mritech.productservicecqrs.controller;

import com.mritech.productservicecqrs.dto.ProductDTO;
import com.mritech.productservicecqrs.query.GetProductsQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductQueryController {

    private final QueryGateway queryGateway;

    public ProductQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping
    public List<ProductDTO> getAllProducts() {

        GetProductsQuery getProductsQuery = new GetProductsQuery();

        List<ProductDTO> productDTOList =
        queryGateway.query(getProductsQuery, ResponseTypes.multipleInstancesOf(ProductDTO.class))
                .join();

        return productDTOList;

    }

}
