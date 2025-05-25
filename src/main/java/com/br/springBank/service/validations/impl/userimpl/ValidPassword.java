package com.br.springBank.service.validations.impl.userimpl;

import com.br.springBank.exception.ValidPasswordException;
import com.br.springBank.service.validations.Validation;
import org.springframework.stereotype.Component;

@Component
public class ValidPassword implements Validation<String> {

    @Override
    public void validate(String password) throws ValidPasswordException {
        if (password == null || password.length() < 8) {
            throw new ValidPasswordException("Password should be at least 8 characters or not null");
        }
    }
}
