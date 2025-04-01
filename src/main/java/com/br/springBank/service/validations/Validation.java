package com.br.springBank.service.validations;

public interface Validation<T> {
    void validate(T object);
}
