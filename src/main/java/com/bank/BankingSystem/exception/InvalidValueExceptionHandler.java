package com.bank.BankingSystem.exception;

public class InvalidValueExceptionHandler extends RuntimeException {
    public InvalidValueExceptionHandler(String messsage) {
        super(messsage);
    }
}
