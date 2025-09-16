package com.bank.BankingSystem.exception;

public class FutureDateException extends RuntimeException {
    public FutureDateException(String message) {
        super(message);
    }
}
