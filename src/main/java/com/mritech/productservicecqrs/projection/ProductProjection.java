package com.mritech.productservicecqrs.projection;

import com.mritech.productservicecqrs.dto.ProductDTO;
import com.mritech.productservicecqrs.entity.Product;
import com.mritech.productservicecqrs.query.GetProductsQuery;
import com.mritech.productservicecqrs.repo.ProductRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductProjection {

    private final ProductRepository productRepository;

    public ProductProjection(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @QueryHandler
    public List<ProductDTO> handle(GetProductsQuery getProductsQuery) {

        List<Product> products = productRepository.findAll();

        List<ProductDTO> productDTOList = products.stream()
                .map(product -> ProductDTO
                        .builder()
                        .quantity(product.getQuantity())
                        .price(product.getPrice())
                        .name(product.getName())
                        .build()
                ).collect(Collectors.toList());

        return productDTOList;
    }
}
