package com.bank.BankingSystem.exception;

public class DuplicateFieldExceptionHandler extends RuntimeException {
    public DuplicateFieldExceptionHandler(String message) {
        super(message);
    }
}
