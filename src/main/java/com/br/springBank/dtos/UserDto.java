package com.br.springBank.dtos;

import jakarta.validation.constraints.NotBlank;

public record UserDto(@NotBlank(message = "nome não pode ser vazio") String name,
                      @NotBlank(message = "email não pode ser vazio") String email,
                      @NotBlank(message = "nome não pode ser vazio") String password) {
}
