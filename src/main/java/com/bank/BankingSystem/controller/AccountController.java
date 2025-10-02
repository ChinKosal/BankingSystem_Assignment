package com.bank.BankingSystem.controller;

import com.bank.BankingSystem.dto.BaseResponse;
import com.bank.BankingSystem.dto.account.AccountRequest;
import com.bank.BankingSystem.entity.Account;
import com.bank.BankingSystem.service.AccountService;
import com.bank.BankingSystem.util.constants.AppConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppConstant.MAIN_PATH + "/accounts")
public class AccountController {
    private AccountService accountService;

    @PostMapping("/create-account")
    public BaseResponse<?> createNewAccount(@RequestBody AccountRequest req){
        return accountService.createNewAccount(req);
    }
}
