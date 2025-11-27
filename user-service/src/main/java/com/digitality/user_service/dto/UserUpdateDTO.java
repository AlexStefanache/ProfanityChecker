package com.digitality.user_service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserUpdateDTO {

	private String name;
	private String surname;
	
	 @Size(min = 6, message = "Password must be at least 6 characters")
	private String password;
	
}
