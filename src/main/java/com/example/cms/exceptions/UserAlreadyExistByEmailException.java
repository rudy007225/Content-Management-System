package com.example.cms.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@SuppressWarnings("serial")
public class UserAlreadyExistByEmailException extends RuntimeException {

	private String message;
	
}
