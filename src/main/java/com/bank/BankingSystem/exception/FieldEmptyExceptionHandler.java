package com.bank.BankingSystem.exception;

public class FieldEmptyExceptionHandler extends RuntimeException {
    public FieldEmptyExceptionHandler(String message) {
        super(message);
    }
}
