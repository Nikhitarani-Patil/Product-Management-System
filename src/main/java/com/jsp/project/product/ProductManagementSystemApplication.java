
package com.jsp.project.product;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableMBeanExport;

import com.jsp.project.product.model.Product;

@SpringBootApplication
public class ProductManagementSystemApplication {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(ProductManagementSystemApplication.class, args);
		
		/*
		Product product = new Product();//o/p:Inside Map
		Optional.of(product).map(p->{System.out.println("Inside Map"); return p;}).orElseThrow(()-> new RuntimeException());
		*/
		
		/*
		Product product = null; //o/p: NullPointerException
		Optional.of(product).map(p->{System.out.println("Inside Map"); return p;}).orElseThrow(()-> new RuntimeException());
		*/
		
		
	}

}
