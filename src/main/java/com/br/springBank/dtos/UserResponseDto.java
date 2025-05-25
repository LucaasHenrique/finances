package com.br.springBank.dtos;

import java.time.Instant;
import java.util.UUID;

public record UserResponseDto(UUID id,
                              String name,
                              String email) {
}
