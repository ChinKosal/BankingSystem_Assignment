package com.bank.BankingSystem.dto.account;

import com.bank.BankingSystem.enums.AccountTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequest {
    private String accountName;
    private String accountEmail;
    private String accountPhone;
    private String national;
    private String accountNumber;
    private AccountTypeEnum accountTypeEnum;
    private Boolean isActive;
}

