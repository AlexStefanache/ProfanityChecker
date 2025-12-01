package com.digitality.service;

import com.digitality.client.UserClient;
import com.digitality.dto.UserRequestDTO;
import com.digitality.dto.UserResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService{
    private UserClient userClient;
    public UserServiceImpl(UserClient userClient) {
        this.userClient = userClient;
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        UserResponseDTO userResponseDTO = userClient.createUser(userRequestDTO);
        return new UserResponseDTO(userResponseDTO.getId(), userResponseDTO.getName(), userResponseDTO.getSurname(), userResponseDTO.getEmail());
    }
}
