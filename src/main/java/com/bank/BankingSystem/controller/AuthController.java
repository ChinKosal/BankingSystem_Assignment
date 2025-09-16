package com.bank.BankingSystem.controller;

import com.bank.BankingSystem.dto.ApiResponse;
import com.bank.BankingSystem.dto.auth.JwtAuthResponse;
import com.bank.BankingSystem.dto.auth.LoginRequest;
import com.bank.BankingSystem.dto.auth.RegisterRequest;
import com.bank.BankingSystem.service.AuthService;
import com.bank.BankingSystem.util.constants.AppConstant;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AppConstant.MAIN_PATH + "/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<JwtAuthResponse>> login(@Valid @RequestBody LoginRequest loginRequest) {
        JwtAuthResponse jwtAuthResponse = authService.login(loginRequest);
        return ResponseEntity.ok(ApiResponse.success("Login successful", jwtAuthResponse));
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<JwtAuthResponse>> register(@Valid @RequestBody RegisterRequest registerRequest) {
        JwtAuthResponse jwtAuthResponse = authService.register(registerRequest);
        return new ResponseEntity<>(ApiResponse.success("User registered successfully", jwtAuthResponse), HttpStatus.CREATED);
    }
}
