package com.digitality.client;

import com.digitality.dto.AuthRequestDTO;
import com.digitality.dto.AuthResponseDTO;
import com.digitality.dto.UserRequestDTO;
import com.digitality.dto.UserResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "user-service")
public interface UserClient {
    @PostMapping("/users")
    public UserResponseDTO createUser(@RequestBody UserRequestDTO request);

    @PostMapping("/auth")
    public AuthResponseDTO authenticate(@RequestBody AuthRequestDTO request);
}
