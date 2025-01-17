package com.jsp.project.product.utility;

import org.springframework.stereotype.Component;

@Component
public class ErrorStructure<T> {
	private int statusCode;
	private String errorMessage;
	private T errorData;
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public T getErrorData() {
		return errorData;
	}
	public void setErrorData(T errorData) {
		this.errorData = errorData;
	}
	@Override
	public String toString() {
		return "ErrorStructure [statusCode=" + statusCode + ", errorMessage=" + errorMessage + "]";
	}


}
