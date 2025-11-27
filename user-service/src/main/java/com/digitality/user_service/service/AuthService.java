package com.digitality.user_service.service;

import com.digitality.user_service.dto.AuthRequestDTO;
import com.digitality.user_service.dto.AuthResponseDTO;

public interface AuthService {
	
	public AuthResponseDTO authenticate(AuthRequestDTO request);

}
