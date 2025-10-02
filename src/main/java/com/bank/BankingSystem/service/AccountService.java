package com.bank.BankingSystem.service;

import com.bank.BankingSystem.dto.BaseResponse;
import com.bank.BankingSystem.dto.account.AccountRequest;

public interface AccountService {
    BaseResponse<?> createNewAccount(AccountRequest req);
}
