package com.digitality.service;

import com.digitality.dto.UserRequestDTO;
import com.digitality.dto.UserResponseDTO;

public interface UserService {

    UserResponseDTO createUser(UserRequestDTO userRequestDTO);
}
