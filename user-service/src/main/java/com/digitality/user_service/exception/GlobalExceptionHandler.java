package com.digitality.user_service.exception;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException e) {
		ErrorResponse error = ErrorResponse.builder()
				.code(e.getCode())
				.message(e.getMessage())
				.status(HttpStatus.NOT_FOUND.value())
				.build();
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleMethodArgumentNotVaidException(MethodArgumentNotValidException e) {
		Map<String, String> details = e.getBindingResult().getFieldErrors()
				.stream().collect(Collectors.toMap(
						fieldError -> fieldError.getField(),
						fieldError -> fieldError.getDefaultMessage()
						));
		ErrorResponse error = ErrorResponse.builder()
				.code("VALIDATION_ERROR")
				.message("Validation failed for one or more fields")
				.status(HttpStatus.BAD_REQUEST.value())
				.details(details)
				.build();
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
