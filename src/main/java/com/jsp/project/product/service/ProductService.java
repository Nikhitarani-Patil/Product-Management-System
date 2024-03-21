package com.jsp.project.product.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.jsp.project.product.dto.ProductRequest;
import com.jsp.project.product.model.Product;
import com.jsp.project.product.utility.ResponseStructure;


public interface ProductService {
	

	public ResponseEntity<ResponseStructure<Product>> findProduct(int productId);

	public ResponseEntity<ResponseStructure<Product>> updateByProductId(int productId, ProductRequest productRequest);

	public ResponseEntity<ResponseStructure<List<Product>>> findAll();

	public ResponseEntity<ResponseStructure<Product>> saveProduct(ProductRequest productRequest);

	public ResponseEntity<ResponseStructure<Product>> deleteByProductId(int productId);
	
	
	
	
	
	
	
	
	/*
	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product);

	public Product updateByProductId(int productId, Product product);

	public Product deleteByProductId(int productId);

	public ResponseEntity<ResponseStructure<Product>> findByProductId(int productId);

	public List<Product> findAllProducts();
	 */


}
