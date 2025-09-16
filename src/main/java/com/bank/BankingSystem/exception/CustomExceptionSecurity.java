package com.bank.BankingSystem.exception;

import com.bank.BankingSystem.enums.IResponseMessage;

public class CustomExceptionSecurity extends RuntimeException {

    public CustomExceptionSecurity() {
        super("Custom Exception");
    }

    public CustomExceptionSecurity(String message) {
        super(message);
    }

    public CustomExceptionSecurity(IResponseMessage resMsgInterface) {
        super(resMsgInterface.getMessage(), new Throwable(resMsgInterface.getCode()));
    }

    public CustomExceptionSecurity(String msgCode, String message) {
        super(msgCode + " : " + message);
    }

}
