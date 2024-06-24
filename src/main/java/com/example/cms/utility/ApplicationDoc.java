package com.example.cms.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@OpenAPIDefinition
public class ApplicationDoc {
	
	Contact contact() {
		return new Contact().name("Rudra").url("instagram.in").email("rudysharma46@gmail.com");
	}
	
	Info info() {
		return new Info().title("Content-Management-System").description("Managing content for the user").version("v1.0")
				.contact(contact());
	}

	@Bean	
	OpenAPI openAPI() {
		return new OpenAPI().info(info());
	}
}
