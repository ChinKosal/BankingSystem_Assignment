package com.bank.BankingSystem.repository.Account;

import com.bank.BankingSystem.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account getById(Integer accountId);
}
