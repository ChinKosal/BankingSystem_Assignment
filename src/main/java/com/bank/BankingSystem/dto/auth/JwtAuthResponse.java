package com.bank.BankingSystem.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JwtAuthResponse {
    private String accessToken;
    private String tokenType;
    private Long userId;
    private String username;
    private String role;
}
