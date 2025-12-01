package com.digitality.client;

import com.digitality.dto.AuthRequestDTO;
import com.digitality.dto.AuthResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "user-service")
@RequestMapping("/auth")
public interface AuthClient {
    @PostMapping
    public ResponseEntity<AuthResponseDTO> authenticate(@RequestBody AuthRequestDTO request);
}
