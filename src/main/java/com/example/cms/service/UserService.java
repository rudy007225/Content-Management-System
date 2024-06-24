package com.example.cms.service;

import org.springframework.http.ResponseEntity;
import com.example.cms.dto.UserRequest;
import com.example.cms.dto.UserResponce;
import com.example.cms.model.User;
import com.example.cms.utility.ResponseStructure;

public interface UserService {

	public ResponseEntity<ResponseStructure<UserResponce>> userRegister(UserRequest user);
	
	public ResponseEntity<ResponseStructure<UserResponce>> softDelete(String email);

	public ResponseEntity<ResponseStructure<UserResponce>> findByUniqueUser(String email);

	
}
