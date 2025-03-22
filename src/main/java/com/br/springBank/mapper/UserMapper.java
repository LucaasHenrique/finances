package com.br.springBank.mapper;

import com.br.springBank.dtos.UserDto;
import com.br.springBank.dtos.UserResponseDto;
import com.br.springBank.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserMapper {

    @Mapping(target = "creationTimestamp", ignore = true)
    @Mapping(target = "updateTimestamp", ignore = true)
    User userDtoToUser(UserDto userDto);

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "updateTimestamp", ignore = true)
    UserResponseDto userToUserResponseDto(User user);
}
