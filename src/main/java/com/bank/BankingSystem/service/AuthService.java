package com.bank.BankingSystem.service;

import com.bank.BankingSystem.dto.auth.JwtAuthResponse;
import com.bank.BankingSystem.dto.auth.LoginRequest;
import com.bank.BankingSystem.dto.auth.RegisterRequest;

public interface AuthService {
    JwtAuthResponse login(LoginRequest loginRequest);
    JwtAuthResponse register(RegisterRequest registerRequest);
}
