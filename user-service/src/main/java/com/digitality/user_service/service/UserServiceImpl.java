package com.digitality.user_service.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.digitality.user_service.dto.UserRequestDTO;
import com.digitality.user_service.dto.UserResponseDTO;
import com.digitality.user_service.dto.UserUpdateDTO;
import com.digitality.user_service.entity.User;
import com.digitality.user_service.exception.UserNotFoundException;
import com.digitality.user_service.mapper.UserMapper;
import com.digitality.user_service.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final UserMapper userMapper;
	
	@Override
	public UserResponseDTO getUser(Long userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException(userId));
		return userMapper.toDTO(user);
	}

	@Override
	public UserResponseDTO createUser(UserRequestDTO request) {
		User user = userMapper.toEntity(request);
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user = userRepository.save(user);
		return userMapper.toDTO(user);
	}

	@Override
	public UserResponseDTO updateUser(UserUpdateDTO update, Long userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException(userId));
		
		userMapper.toUpdate(update, user);
		
		if (update.getPassword() != null) {
			user.setPassword(passwordEncoder.encode(update.getPassword()));
		}
		user = userRepository.save(user);
		return userMapper.toDTO(user);
	}

}
