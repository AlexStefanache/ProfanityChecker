package com.digitality.user_service.mapper;

import org.springframework.stereotype.Component;

import com.digitality.user_service.dto.UserRequestDTO;
import com.digitality.user_service.dto.UserResponseDTO;
import com.digitality.user_service.dto.UserUpdateDTO;
import com.digitality.user_service.entity.User;

@Component
public class UserMapper {
	
	public UserResponseDTO toDTO(User user) {
		return UserResponseDTO.builder()
				.id(user.getId())
				.name(user.getName())
				.surname(user.getSurname())
				.email(user.getEmail())
				.build();
	}
	
	public User toEntity(UserRequestDTO request) {
		return User.builder()
				.name(request.getName())
				.surname(request.getSurname())
				.email(request.getEmail())
				.password(request.getPassword())
				.build();
	}
	
	public User toUpdate(User user, UserUpdateDTO update) {
		if (update.getName() != null) {
			user.setName(update.getName());
		}
		
		if (update.getSurname() != null) {
			user.setSurname(update.getSurname());
		}
		
		return user;
	}
}
