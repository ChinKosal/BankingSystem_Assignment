package com.bank.BankingSystem.payload.User;

import com.bank.BankingSystem.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPrinciple implements UserDetails {

    private Long id;
    private String username;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public static UserPrinciple build(Users user) {
        List<GrantedAuthority> authorities = List.of(
                new SimpleGrantedAuthority(user.getRole().getName())
        );
        return new UserPrinciple(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                authorities
        );
    }

    // Implement all UserDetails methods (getAuthorities, getPassword, getUsername, etc.)
}

