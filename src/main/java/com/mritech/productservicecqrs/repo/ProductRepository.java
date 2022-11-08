package com.mritech.productservicecqrs.repo;

import com.mritech.productservicecqrs.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {

}
