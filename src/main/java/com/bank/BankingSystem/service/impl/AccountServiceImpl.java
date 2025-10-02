package com.bank.BankingSystem.service.impl;

import com.bank.BankingSystem.dto.BaseResponse;
import com.bank.BankingSystem.dto.account.AccountRequest;
import com.bank.BankingSystem.repository.Account.AccountRepository;
import com.bank.BankingSystem.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl  implements AccountService {
    private AccountRepository accountRepository;
    @Override
    public BaseResponse<?> createNewAccount(AccountRequest req) {

        return null;
    }
}
