package com.jsp.project.product.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.project.product.model.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

}
