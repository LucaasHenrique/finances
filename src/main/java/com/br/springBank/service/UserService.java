package com.br.springBank.service;

import com.br.springBank.dtos.UpdateUserDto;
import com.br.springBank.dtos.UserDto;
import com.br.springBank.dtos.UserLoginDto;
import com.br.springBank.dtos.UserResponseDto;
import com.br.springBank.exception.EmailAlreadyExistsException;
import com.br.springBank.exception.UserNotFoundException;
import com.br.springBank.mapper.UserMapper;
import com.br.springBank.model.User;
import com.br.springBank.model.types.UserRole;
import com.br.springBank.repository.UserRepository;
import com.br.springBank.service.validations.Validation;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final Validation<String> validation;
    private final List<User> users = new ArrayList<>();

    public UserService(UserRepository userRepository, Validation<String> validation) {
        this.userRepository = userRepository;
        this.validation = validation;
    }

    public UserResponseDto createUser(UserDto userDto) {
        validation.validate(userDto.password());

        if (userRepository.existsByEmail(userDto.email())) {
            throw new EmailAlreadyExistsException("Email already in use");
        }

        var user = UserMapper.INSTANCE.userDtoToUser(userDto);
        user.setRole(UserRole.USER);
        userRepository.save(user);

        return UserMapper.INSTANCE.userToUserResponseDto(user);
    }

    public void verifyUser(UserLoginDto userLoginDto) {

    }

    public UserResponseDto getUser(UUID id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));

        return UserMapper.INSTANCE.userToUserResponseDto(user);
    }

    public UserResponseDto updateUser(UUID id, UpdateUserDto userDto) {
        var user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));

        applyUpdate(user, userDto);

        return UserMapper.INSTANCE.userToUserResponseDto(userRepository.save(user));
    }

    public void deleteUser(UUID id) {
        var user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));

        userRepository.deleteById(id);
    }

    private void applyUpdate(User user, UpdateUserDto updateUserDto) {
        if (updateUserDto.name() != null) {
            user.setName(updateUserDto.name());
        }

        if (updateUserDto.email() != null) {
            user.setEmail(updateUserDto.email());
        }

        if (updateUserDto.oldpassword() != null && updateUserDto.oldpassword().equals(user.getPassword())) {
            user.setPassword(updateUserDto.newpassword());
        }
    }
}
