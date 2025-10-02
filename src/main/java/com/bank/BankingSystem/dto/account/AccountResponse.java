package com.bank.BankingSystem.dto.account;

import com.bank.BankingSystem.payload.User.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponse {
    private String accountName;
    private String accountEmail;
    private String accountPhone;
    private String national;
    private String accountNumber;
    private String accountTypeEnum;
    private Boolean isActive;
    private UserResponse user;
}

