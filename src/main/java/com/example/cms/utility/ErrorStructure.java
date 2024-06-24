package com.example.cms.utility;
//This Component returns Responce where any kind of Error Arises, in a specific formate with proper statuscode and message
//and description regarding error. 
import org.springframework.stereotype.Component;

@Component
public class ErrorStructure<T> {
	
	private int errorCode;
	private String message;
	private T rootCause;
	
	public int getErrorCode() {
		return errorCode;
	}
	public ErrorStructure<T> setErrorCode(int errorCode) {
		this.errorCode = errorCode;
		return this;
	}
	public String getMessage() {
		return message;
	}
	public ErrorStructure<T> setMessage(String message) {
		this.message = message;
		return this;
	}
	public T getRootCause() {
		return rootCause;
	}
	public ErrorStructure<T> setRootCause(T rootCause) {
		this.rootCause = rootCause;
		return this;
	}
}
