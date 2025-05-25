package com.br.springBank.dtos;

import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.UUID;

public record WalletDto(@NotBlank String bankName,
                        @NotBlank BigDecimal balance,
                        @NotBlank UUID userId) {
}
