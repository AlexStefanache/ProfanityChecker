package com.digitality.user_service.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.digitality.user_service.dto.AuthRequestDTO;
import com.digitality.user_service.dto.AuthResponseDTO;
import com.digitality.user_service.entity.User;
import com.digitality.user_service.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	@Override
	public AuthResponseDTO authenticate(AuthRequestDTO request) {
		boolean isValid = false;
		Optional<User> optUser = userRepository.findByEmail(request.getEmail());
		if (optUser.isPresent()) {
			if (passwordEncoder.matches(request.getPassword(), optUser.get().getPassword())) {
				isValid = true;
			}
		}
		return AuthResponseDTO.builder().isValid(isValid).build();
	}

}
