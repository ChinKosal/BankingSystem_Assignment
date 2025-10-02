package com.bank.BankingSystem.service.impl;

import com.bank.BankingSystem.dto.auth.JwtAuthResponse;
import com.bank.BankingSystem.dto.auth.LoginRequest;
import com.bank.BankingSystem.dto.auth.RegisterRequest;
import com.bank.BankingSystem.entity.Role;
import com.bank.BankingSystem.entity.Users;
import com.bank.BankingSystem.exception.ErrorException;
import com.bank.BankingSystem.payload.User.UserPrinciple;
import com.bank.BankingSystem.repository.RoleRepository;
import com.bank.BankingSystem.repository.User.UserRepository;
import com.bank.BankingSystem.service.AuthService;
import com.bank.BankingSystem.util.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtTokenProvider;

    @Override
    public JwtAuthResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginRequest.getUsernameOrEmail(),
                loginRequest.getPassword()
            )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken((UserPrinciple) authentication);

        Users user = userRepository.findByEmail(loginRequest.getUsernameOrEmail());

        return JwtAuthResponse.builder()
                .accessToken(token)
                .tokenType("Bearer")
                .userId(user.getId())
                .username(user.getUsername())
                .role(user.getRole() != null ? user.getRole().getName() : null)
                .build();
    }

    @Override
    public JwtAuthResponse register(RegisterRequest registerRequest) {
        Users existingUser = userRepository.findByEmail(registerRequest.getEmail());
        if (existingUser != null) {
            throw new ErrorException(203, "Email is already taken");
        }

        // Create new user
        Users user = new Users();
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setPhoneNumber(registerRequest.getPhoneNumber());
        user.setActive(true);

        Role userRole = roleRepository.findByName("USER")
                .orElseThrow(() -> new RuntimeException("Default role not found"));
        user.setRole(userRole);

        Users savedUser = userRepository.save(user);

        // Directly generate JWT without re-authenticating
        String token = jwtTokenProvider.generateToken(UserPrinciple.build(savedUser));

        return JwtAuthResponse.builder()
                .accessToken(token)
                .tokenType("Bearer")
                .userId(savedUser.getId())
                .username(savedUser.getUsername())
                .role(savedUser.getRole() != null ? savedUser.getRole().getName() : null)
                .build();
    }

}
