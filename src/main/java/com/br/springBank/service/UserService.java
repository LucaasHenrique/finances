package com.br.springBank.service;

import com.br.springBank.dtos.UserDto;
import com.br.springBank.mapper.UserMapper;
import com.br.springBank.model.types.UserRole;
import com.br.springBank.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UUID createUser(UserDto userDto) {
        var user = userMapper.userDtoToUser(userDto);
        user.setRole(UserRole.USER);
        userRepository.save(user);
        return user.getId();
    }
}
