package com.bank.BankingSystem.exception;

public class UserDuplicateExceptionHandler extends RuntimeException {
    public UserDuplicateExceptionHandler(String message) {
        super(message);
    }
}
