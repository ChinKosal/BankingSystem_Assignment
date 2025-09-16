package com.bank.BankingSystem.controller;

import com.bank.BankingSystem.dto.ApiResponse;
import com.bank.BankingSystem.entity.Users;
import com.bank.BankingSystem.service.AdminService;
import com.bank.BankingSystem.util.constants.AppConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(AppConstant.MAIN_PATH + "/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<List<Users>>> getAllUsers() {
        List<Users> users = adminService.getAllUsers();
        return ResponseEntity.ok(ApiResponse.success(users));
    }

    @GetMapping("/users/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<Users>> getUserById(@PathVariable Long id) {
        Users user = adminService.getUserById(id);
        return ResponseEntity.ok(ApiResponse.success(user));
    }

    @PutMapping("/users/{id}/activate")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<Users>> activateUser(@PathVariable Long id) {
        Users user = adminService.activateUser(id);
        return ResponseEntity.ok(ApiResponse.success("User activated successfully", user));
    }

    @PutMapping("/users/{id}/deactivate")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<Users>> deactivateUser(@PathVariable Long id) {
        Users user = adminService.deactivateUser(id);
        return ResponseEntity.ok(ApiResponse.success("User deactivated successfully", user));
    }

    @PutMapping("/users/{id}/role/{roleId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<Users>> changeUserRole(@PathVariable Long id, @PathVariable Long roleId) {
        Users user = adminService.changeUserRole(id, roleId);
        return ResponseEntity.ok(ApiResponse.success("User role updated successfully", user));
    }

    @DeleteMapping("/users/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable Long id) {
        adminService.deleteUser(id);
        return new ResponseEntity<>(ApiResponse.success("User deleted successfully", null), HttpStatus.NO_CONTENT);
    }
}
