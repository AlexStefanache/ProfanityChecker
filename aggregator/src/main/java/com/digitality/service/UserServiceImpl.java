package com.digitality.service;

import com.digitality.dto.UserRequestDTO;
import com.digitality.dto.UserResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService{
    private String apiUrl = "http://user-service/users";

    private RestTemplate restTemplate;
    public UserServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        UserResponseDTO userResponseDTO = restTemplate.postForObject(apiUrl, userRequestDTO, UserResponseDTO.class);
        return new UserResponseDTO(userResponseDTO.getId(), userResponseDTO.getName(), userResponseDTO.getSurname(), userResponseDTO.getEmail());
    }
}
