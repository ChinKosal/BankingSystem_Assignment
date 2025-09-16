package com.bank.BankingSystem.service;

import com.bank.BankingSystem.entity.Users;

import java.util.List;

public interface AdminService {
    List<Users> getAllUsers();
    Users getUserById(Long id);
    Users activateUser(Long id);
    Users deactivateUser(Long id);
    Users changeUserRole(Long userId, Long roleId);
    void deleteUser(Long id);
}
