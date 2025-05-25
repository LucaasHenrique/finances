package com.br.springBank.service.validations.impl.userimpl;

import com.br.springBank.exception.BalanceNotZeroException;
import com.br.springBank.service.validations.Validation;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ValidBalance implements Validation<BigDecimal> {

    @Override
    public void validate(BigDecimal balance) {
        if (balance == null && balance.compareTo(BigDecimal.ZERO) < 0) {
            throw new BalanceNotZeroException("Balance should be greater than zero");
        }
    }
}
