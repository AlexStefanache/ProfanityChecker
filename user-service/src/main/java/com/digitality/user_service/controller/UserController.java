package com.digitality.user_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitality.user_service.dto.UserRequestDTO;
import com.digitality.user_service.dto.UserResponseDTO;
import com.digitality.user_service.dto.UserUpdateDTO;
import com.digitality.user_service.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController	
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserResponseDTO> getUser(@PathVariable Long userId) {
		return ResponseEntity.ok(userService.getUser(userId));
	}
	
	@PostMapping
	public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO request) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(request));
	}
	
	@PatchMapping("/{userId}")
	public ResponseEntity<UserResponseDTO> updateUser(@RequestBody UserUpdateDTO update, @PathVariable Long userId) {
		return ResponseEntity.ok(userService.updateUser(update, userId));
	}
}
