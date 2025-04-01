package com.br.springBank.service.validations.impl.userimpl;

import com.br.springBank.dtos.UserDto;
import com.br.springBank.exception.ValidPasswordException;
import com.br.springBank.service.validations.Validation;
import org.springframework.stereotype.Component;

@Component
public class ValidPassword implements Validation<UserDto> {

    @Override
    public void validate(UserDto userDto) throws ValidPasswordException {
        if (userDto.password() == null || userDto.password().length() < 8) {
            throw new ValidPasswordException("Password should be at least 8 characters or not null");
        }
    }
}
