package com.example.cms.serviceimpl;




import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.cms.dto.UserRequest;
import com.example.cms.dto.UserResponce;

import com.example.cms.exceptions.UserAlreadyExistByEmailException;
import com.example.cms.exceptions.UserNotFoundException;
import com.example.cms.model.User;
import com.example.cms.repository.UserRepo;
import com.example.cms.service.UserService;
import com.example.cms.utility.ResponseStructure;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class UserSeviceImpl implements UserService {

	private UserRepo repository;
	private ResponseStructure<UserResponce> structure;
	private PasswordEncoder passwordEncoder;


	//	REGISTERING THE USER

	@Override
	public ResponseEntity<ResponseStructure<UserResponce>> userRegister(UserRequest userRequest){
		if(repository.existsByEmail(userRequest.getEmail())){
			throw new UserAlreadyExistByEmailException("failed to load user..");
		}
		User userObject = repository.save(mapToUserEntity(userRequest, new User()));
		return ResponseEntity.ok(structure.setStatusCode(HttpStatus.OK.value())
				.setMessage("Data Sucsessfully Saved")
				.setData(mapToUserResponce(userObject)));
	}

	private UserResponce mapToUserResponce(User user) {

		return UserResponce.builder().userId(user.getUserId()).userName(user.getUserName()).email(user.getEmail())
				.lastModifiedAt(user.getLastModifiedAt())
				.createdAt(user.getCreatedAt())
				.build();
	}

	private User mapToUserEntity(UserRequest userRequest, User user) {
		user.setUserName(userRequest.getUserName());
		user.setEmail(userRequest.getEmail());
		user.setPassword(passwordEncoder.encode(userRequest.getPassword())); //Encoded Password is been injected
		return user;
	}


	//	SOFT DELETING THE USER 

	@Override
	public ResponseEntity<ResponseStructure<UserResponce>> softDelete(String email) {
		User user = repository.findByEmail(email)
				.orElseThrow(() -> new UserNotFoundException("User with ID " + email + " not found."));
		user.setDeleted(true);
		repository.save(user);

		return ResponseEntity.ok(structure.setStatusCode(HttpStatus.OK.value())
				.setMessage("User with ID " + email + " soft deleted successfully.")
				.setData(mapToUserResponse(user)));

		/*
		 * Optional <User> byEmail = repository.findByEmail(email);
		 * if(byEmail.isPresent()) { User user = byEmail.get(); user.setDeleted(true);
		 * repository.save(user);
		 * 
		 * return ResponseEntity.ok(structure.setStatusCode(HttpStatus.OK.value())
		 * .setMessage("User soft deleted successfully")
		 * .setData(mapToUserResponce(user))); } else { throw new
		 * UserNotFoundException("User with ID " + email + " not found."); } }
		 */
	}

	private UserResponce mapToUserResponse(User user) {
		return UserResponce.builder()
				.userId(user.getUserId())
				.userName(user.getUserName())
				.email(user.getEmail())
				.lastModifiedAt(user.getLastModifiedAt())
				.createdAt(user.getCreatedAt())
				.build();
	}

	private User mapToUserEntity(UserRequest userRequest) {
		User user = new User();
		user.setUserName(userRequest.getUserName());
		user.setEmail(userRequest.getEmail());
		user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
		user.setDeleted(false);   
		// Set deleted as false by default for new user registration
		return user;
	}

	//	FINDING USER BY UNIQUE USER

	@Override
	public ResponseEntity<ResponseStructure<UserResponce>> findByUniqueUser(String email) {
		Optional<User> optionalUser = repository.findByEmail(email);
		if (optionalUser.isPresent()){ User user = optionalUser.get();

		repository.save(user);

		return ResponseEntity.ok(structure.setStatusCode(HttpStatus.OK.value())
				.setMessage("User found successfully")
				.setData(mapToUserResponce(user)));
		} else{ 
			throw new UserNotFoundException("User with ID " + email + " not found.");
			}
		}
		
				
		/*return repository.findByEmail(email).map(user-> {
			UserResponce responce= mapToUserResponce(user);
		
				ResponseEntity.ok(structure.setStatusCode(HttpStatus.OK.value())
				.setMessage("User with ID " + email + " soft deleted successfully.")
				.setData(mapToUserResponse(user)));
	}*/
	

}






