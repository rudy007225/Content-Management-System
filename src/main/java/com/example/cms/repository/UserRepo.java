package com.example.cms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.cms.model.User;
@EnableJpaRepositories
public interface UserRepo extends JpaRepository<User, Integer> {

	boolean existsByEmail(String email);
	
	Optional<User> findByEmail(String email);
	
	
}
