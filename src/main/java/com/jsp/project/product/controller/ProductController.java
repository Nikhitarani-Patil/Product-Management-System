package com.jsp.project.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.project.product.dto.ProductRequest;
import com.jsp.project.product.model.Product;
import com.jsp.project.product.service.ProductService;
import com.jsp.project.product.utility.ResponseStructure;

@RestController
public class ProductController {

    // @Autowired
	private ProductService productService;
	
	
	public ProductController(ProductService productService) {
		this.productService=productService;
	}

	@PostMapping(value = "/products")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody ProductRequest productRequest){
		return productService.saveProduct(productRequest);
	}
	
	@GetMapping(value = "/products/{productId}")
	public ResponseEntity<ResponseStructure<Product>> findProduct(@PathVariable int productId){
		return productService.findProduct(productId);
	}
	
	@PutMapping(value = "/products/{productId}")
	public ResponseEntity<ResponseStructure<Product>> updateByProductId(@PathVariable int productId, @RequestBody ProductRequest productRequest){
		return productService.updateByProductId(productId , productRequest);
	}
	
	@DeleteMapping(value = "/products/{productId}")
	public ResponseEntity<ResponseStructure<Product>> deleteByProductId(@PathVariable int productId){
		return productService.deleteByProductId(productId);
	}
	
	@GetMapping(value = "/products")
	public ResponseEntity<ResponseStructure<List<Product>>> findAll(){
		return productService.findAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	@PostMapping(value = "/products/saveProduct")
	public  ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	@PutMapping(value = "/products/updateByProductId")
	public Product updateByProductId(@RequestParam int productId, @RequestBody Product product) {
		return productService.updateByProductId(productId, product);
	}
	
	@DeleteMapping(value = "/products/deleteByProductId")
	public Product deleteByProductId(@RequestParam int productId) {
		return productService.deleteByProductId(productId);
	}
	
	@GetMapping(value = "/products/findByProductId")
	public ResponseEntity<ResponseStructure<Product>> findByProductId(@RequestParam int productId) {
		return productService.findByProductId(productId);
	}
	
	@GetMapping(value = "/products/findAllProducts")
	public List<Product> findAllProducts(){
		return productService.findAllProducts();
		}
		*/
	
}










