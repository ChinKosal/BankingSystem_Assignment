package com.bank.BankingSystem.exception;

public class NotFoundExceptionHandler extends RuntimeException {
    public NotFoundExceptionHandler(String message) {
        super(message);
    }
}
