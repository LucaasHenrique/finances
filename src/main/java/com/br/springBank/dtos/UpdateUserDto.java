package com.br.springBank.dtos;

public record UpdateUserDto(String name, String email, String oldpassword, String newpassword) {
}
