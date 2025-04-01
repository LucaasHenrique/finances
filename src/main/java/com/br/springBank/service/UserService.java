package com.br.springBank.service;

import com.br.springBank.dtos.UserDto;
import com.br.springBank.exception.EmailAlreadyExistsException;
import com.br.springBank.mapper.UserMapper;
import com.br.springBank.model.User;
import com.br.springBank.model.types.UserRole;
import com.br.springBank.repository.UserRepository;
import com.br.springBank.service.validations.Validation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final Validation<UserDto> validation;
    private final List<User> users = new ArrayList<>();

    public UserService(UserRepository userRepository, Validation<UserDto> validation) {
        this.userRepository = userRepository;
        this.validation = validation;
    }

    public UUID createUser(UserDto userDto) {
        validation.validate(userDto);

        if (userRepository.existsByEmail(userDto.email())) {
            throw new EmailAlreadyExistsException("Email already in use");
        }

        var user = UserMapper.INSTANCE.userDtoToUser(userDto);
        user.setRole(UserRole.USER);
        userRepository.save(user);
        return user.getId();
    }
}
