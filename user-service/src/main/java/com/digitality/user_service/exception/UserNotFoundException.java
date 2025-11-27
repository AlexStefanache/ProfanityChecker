package com.digitality.user_service.exception;

public class UserNotFoundException extends RuntimeException{
	private final String code = "USER_NOT_FOUND";
	public UserNotFoundException(Long userId) {
		super("User with id " + userId + " doesn't exist");
	}
	
	public String getCode() {
		return code;
	}
}
