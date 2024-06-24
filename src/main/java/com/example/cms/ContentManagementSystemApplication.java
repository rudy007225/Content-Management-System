package com.example.cms;

/*
		# Content Management System
		
		A simple CMS API designed for managing BlogPosts, serving as a backend service built with Spring Boot 
		and utilizing RESTful architecture.
		
	
		⛳ **Key Takeaways :**
		
		- 🔥 Master Complex Entity Relationship Management using JPA
		- 📊 Understand UML notations and efficiently use them do structure the entity relationship and database
		- ⏰ Explore Schedulers and use them effectively on real-time cases.
		- 🔒 Handle Authentication using Spring Security
		- 🔍 Implemented Entity Auditing to maintain data integrity.
		- ✨ Hands on Experience on efficiently using DTOs, Field Validations, OpenAPI documentation, 
		RODs and ResponseStructure.
*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContentManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentManagementSystemApplication.class, args);
	}

}
