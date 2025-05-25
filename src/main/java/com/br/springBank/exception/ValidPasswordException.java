package com.br.springBank.exception;

public class ValidPasswordException extends RuntimeException {
    public ValidPasswordException(String message) {
        super(message);
    }
}
