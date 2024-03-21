package com.jsp.project.product.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.project.product.exception.ProductNotFoundByIdException;

@RestControllerAdvice
public class ApplicationHandler {


	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> ProductNotFoundException(ProductNotFoundByIdException ex){
		ErrorStructure errorStructure= new ErrorStructure();
		errorStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorStructure.setErrorMessage(ex.getMessage());
		errorStructure.setErrorData("Product with given id not found");

		return new ResponseEntity<ErrorStructure<String>>(errorStructure,HttpStatus.NOT_FOUND);
	}
}
