package com.bank.BankingSystem.exception;

public class InvalidDateFormatException extends RuntimeException {
    public InvalidDateFormatException(String message) {
        super(message);
    }
}