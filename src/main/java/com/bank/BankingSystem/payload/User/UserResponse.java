package com.bank.BankingSystem.payload.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Integer id;
    private String fullName;
    private String email;
    private String profileImage;
    private String phoneNumber;
    private String location;
}
