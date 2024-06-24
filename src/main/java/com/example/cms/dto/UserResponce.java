package com.example.cms.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponce {

	private int userId;
	private String userName;
	private String email;
	
	private LocalDateTime createdAt;
	private LocalDateTime lastModifiedAt;
}
