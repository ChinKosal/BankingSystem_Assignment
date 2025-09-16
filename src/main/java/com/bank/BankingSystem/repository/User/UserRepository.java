package com.bank.BankingSystem.repository.User;

import com.bank.BankingSystem.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Users getById(Integer userId);

    Users findByEmail(String email);
}
