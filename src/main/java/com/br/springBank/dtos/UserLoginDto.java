package com.br.springBank.dtos;

import jakarta.validation.constraints.NotBlank;

public record UserLoginDto (@NotBlank(message = "Email não pode ser vazio") String email,
                            @NotBlank(message = "Senha não pode ser vazia") String password){
}
