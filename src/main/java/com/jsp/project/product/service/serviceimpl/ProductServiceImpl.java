package com.jsp.project.product.service.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.project.product.dto.ProductRequest;
import com.jsp.project.product.exception.ProductNotFoundByIdException;
import com.jsp.project.product.model.Product;
import com.jsp.project.product.repo.ProductRepo;
import com.jsp.project.product.service.ProductService;
import com.jsp.project.product.utility.ResponseStructure;

@Service
public class ProductServiceImpl implements ProductService{

//	@Autowired
	private ProductRepo repo;
	private ResponseStructure<Product> structure;
	private ResponseStructure<List<Product>> structureList;

	
	public ProductServiceImpl(ProductRepo repo, ResponseStructure<Product> structure,
			ResponseStructure<List<Product>> structureList) {
		super();
		this.repo = repo;
		this.structure = structure;
		this.structureList = structureList;
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> findProduct(int productId) {
		return repo.findById(productId).map(product -> ResponseEntity.ok(
				structure.setStatus(HttpStatus.OK.value())
				.setMessage("Product Found")
				.setData(product)))
				.orElseThrow(() -> new ProductNotFoundByIdException("Product Not Found By Id "));
		
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> updateByProductId(int productId, ProductRequest productRequest) {
		Product updatedProduct = mapToProduct(productRequest, new Product());
		return repo.findById(productId).map(exProduct -> {
			updatedProduct.setProductId(exProduct.getProductId());
			exProduct = repo.save(updatedProduct);
			return ResponseEntity.ok(structure.setStatus(HttpStatus.OK.value())
					.setMessage("Product Data Updated Successfully!!")
					.setData(updatedProduct));
		}).orElseThrow(()-> new ProductNotFoundByIdException("Product Not Updated"));
	
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Product>>> findAll() {
		return ResponseEntity.ok(structureList.setStatus(HttpStatus.OK.value())
				.setMessage("Product Data Fetched Successfully!!")
				.setData(repo.findAll()));
	}
	
	

	@Override
	public ResponseEntity<ResponseStructure<Product>> saveProduct(ProductRequest product) {
		return ResponseEntity.ok(structure.setStatus(HttpStatus.OK.value())
				.setMessage("Product Data Saved Successfully!!")
				.setData(repo.save(mapToProduct(product, new Product()))));
	}

	private Product mapToProduct(ProductRequest product, Product product2) {
		product2.setProductName(product.getProductName());
		product2.setProductCost(product.getProductCost());
		return product2;
	}
	

	@Override
	public ResponseEntity<ResponseStructure<Product>> deleteByProductId(int productId) {
		Optional<Product> optional = repo.findById(productId);
		return optional.map(product -> {repo.delete(product);
		return ResponseEntity.ok(structure.setStatus(HttpStatus.OK.value()).setMessage("Product Data Deleted Successfully!!"));
		}).orElse(null);

	}
	
	
	
	
	
	
     /*
	@Override
	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) {
		Product product2 = repo.save(product);
		
		ResponseStructure<Product> responseStructure = new ResponseStructure<>();
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setMessage("product object saved successfully");
		responseStructure.setData(product2);
		return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.CREATED);
	}


	@Override
	public Product updateByProductId(int productId, Product updateProduct) {
		Optional<Product> optional = repo.findById(productId);
		
		if(optional.isPresent()) {
			Product existProduct = optional.get();
			updateProduct.setProductId(existProduct.getProductId());
			return repo.save(updateProduct);
		}else {
			throw new com.jsp.project.product.exception.ProductNotFoundByIdException("Product not found");
		}
	}


	@Override
	public Product deleteByProductId(int productId) {
		Optional<Product> optional = repo.findById(productId);
		
		if(optional.isPresent()) {
			Product product = optional.get();
			repo.delete(product);
			return product;
		}else {
			throw new com.jsp.project.product.exception.ProductNotFoundByIdException("Product not found");
		}
	}
*/
//
//	@Override
//	public ResponseEntity<ResponseStructure<Product>> findByProductId(int productId) {
//		Optional<Product> optional = repo.findById(productId);
//		
//		if(optional.isPresent()) {
//			Product product=optional.get();
//			
//			return repo.findById(productId).map(p->{ResponseStructure<Product> s=new ResponseStructure();
//			return ResponseEntity.ok(s);}).orElseThrow(()-> new ProductNotFoundByIdException("Product Not Found"));
//			/*
//			ResponseStructure<Product> responseStructure = new ResponseStructure<>();
//			responseStructure.setStatuscode(HttpStatus.FOUND.value());
//			responseStructure.setMessage("product found successfully");
//			responseStructure.setData(product);
//			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.FOUND);
//			*/
//		}else {
//			throw new com.jsp.project.product.exception.ProductNotFoundByIdException("Product not found");
//		}
//	}
//
//
//	@Override
//	public List<Product> findAllProducts() {
//		List<Product> product=repo.findAll();
//		
//		if(product.isEmpty()) {
//			throw new com.jsp.project.product.exception.ProductNotFoundByIdException("Product not found");
//		}else {
//		return product;
//		}
//	}
//



}
