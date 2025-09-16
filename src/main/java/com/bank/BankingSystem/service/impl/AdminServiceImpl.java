package com.bank.BankingSystem.service.impl;

import com.bank.BankingSystem.entity.Role;
import com.bank.BankingSystem.entity.Users;
import com.bank.BankingSystem.repository.RoleRepository;
import com.bank.BankingSystem.repository.User.UserRepository;
import com.bank.BankingSystem.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users getUserById(Long id) {
        return userRepository.findById(id.intValue())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public Users activateUser(Long id) {
        Users user = getUserById(id);
        user.setActive(true);
        return userRepository.save(user);
    }

    @Override
    public Users deactivateUser(Long id) {
        Users user = getUserById(id);
        user.setActive(false);
        return userRepository.save(user);
    }

    @Override
    public Users changeUserRole(Long userId, Long roleId) {
        Users user = getUserById(userId);
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + roleId));

        user.setRole(role);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        Users user = getUserById(id);
        userRepository.delete(user);
    }
}
