package com.bank.BankingSystem.entity;

import com.bank.BankingSystem.config.base.BaseEntity;
import com.bank.BankingSystem.enums.AccountTypeEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Account extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountName;
    private String accountEmail;
    private String accountPhone;
    private String national;
    private String accountNumber;
    private AccountTypeEnum accountTypeEnum;
    private Boolean isActive = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private Users user;

}
