package com.br.springBank.mapper;

import com.br.springBank.dtos.WalletDto;
import com.br.springBank.model.Wallet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface WalletMapper {

    WalletMapper INSTANCE = Mappers.getMapper(WalletMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "transactions", ignore = true)
    @Mapping(target = "user", ignore = true)
    Wallet walletDtoToWallet(WalletDto walletDto);
}

