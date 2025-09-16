package com.bank.BankingSystem.entity;

import com.bank.BankingSystem.config.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Users extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String phoneNumber;
    private Boolean active;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = true)
    private Role role;

    public Users(Long id, String firstName, String lastName, String email, String username, String password, String phoneNumber, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }
}
