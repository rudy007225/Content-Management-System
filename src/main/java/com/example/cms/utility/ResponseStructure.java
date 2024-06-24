package com.example.cms.utility;
//This Component returns Responce in JSON but in a specific formate with proper statuscode and message
//and description 
import org.springframework.stereotype.Component;


@Component
public class ResponseStructure<E> {

	private int statusCode;
	private String message;
	private E data;
	
	public int getStatusCode() {
		return statusCode;
	}
	public ResponseStructure<E> setStatusCode(int statusCode) {
		this.statusCode = statusCode;
		return this;
	}
	public String getMessage() {
		return message;
	}
	public ResponseStructure<E> setMessage(String message) {
		this.message = message;
		return this;
	}
	public E getData() {
		return data;
	}
	public ResponseStructure<E> setData(E userResponce) {
		this.data = userResponce;
		return this;
	}
}
