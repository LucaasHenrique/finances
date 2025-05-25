package com.br.springBank.service;

import com.br.springBank.dtos.WalletDto;
import com.br.springBank.mapper.WalletMapper;
import com.br.springBank.model.Wallet;
import com.br.springBank.repository.WalletRepository;
import com.br.springBank.service.validations.Validation;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class WalletService {

    private final WalletRepository walletRepository;
    private final Validation<BigDecimal> validation;

    public WalletService(WalletRepository walletRepository, Validation<BigDecimal> validation) {
        this.walletRepository = walletRepository;
        this.validation = validation;
    }

    public WalletDto addBankAccount(WalletDto walletDto) {
        validation.validate(walletDto.balance());

        var wallet = WalletMapper.INSTANCE.walletDtoToWallet(walletDto);
        return walletDto;
    }
}
