package com.br.springBank.dtos;

import jakarta.validation.constraints.NotBlank;

public record UserDto(@NotBlank(message = "nome não pode ser null") String name,
                      @NotBlank String email,
                      @NotBlank String password) {
}
