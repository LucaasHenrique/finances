package com.br.springBank;

import com.br.springBank.dtos.UserDto;
import com.br.springBank.dtos.UserResponseDto;
import com.br.springBank.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationTimestamp", ignore = true)
    @Mapping(target = "updateTimestamp", ignore = true)
    @Mapping(target = "categorys", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "account", ignore = true)
    @Mapping(target = "transactions", ignore = true)
    User userDtoToUser(UserDto userDto);

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "updateTimestamp", ignore = true)
    List<UserResponseDto> usersToUserResponseDto(List<User> user);
}
