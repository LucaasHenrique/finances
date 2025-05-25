package com.br.springBank.exception;

public class BalanceNotZeroException extends RuntimeException {
    public BalanceNotZeroException(String message) {
        super(message);
    }
}
