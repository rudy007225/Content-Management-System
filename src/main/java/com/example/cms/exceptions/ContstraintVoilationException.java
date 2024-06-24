package com.example.cms.exceptions;

public class ContstraintVoilationException extends RuntimeException{
		
	private String message;

	public ContstraintVoilationException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
}
