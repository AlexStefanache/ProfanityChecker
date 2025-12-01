package com.digitality.user_service.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.digitality.user_service.dto.UserRequestDTO;
import com.digitality.user_service.dto.UserResponseDTO;
import com.digitality.user_service.dto.UserUpdateDTO;
import com.digitality.user_service.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	UserResponseDTO toDTO(User user);
	User toEntity(UserRequestDTO request);
	
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void toUpdate(UserUpdateDTO update, @MappingTarget User user);

}
