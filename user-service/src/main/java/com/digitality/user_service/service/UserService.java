package com.digitality.user_service.service;

import com.digitality.user_service.dto.UserRequestDTO;
import com.digitality.user_service.dto.UserResponseDTO;
import com.digitality.user_service.dto.UserUpdateDTO;

public interface UserService{
	
	public UserResponseDTO getUser(Long userId);
	public UserResponseDTO createUser(UserRequestDTO request);
	public UserResponseDTO updateUser(UserUpdateDTO update, Long userId);
	
}
