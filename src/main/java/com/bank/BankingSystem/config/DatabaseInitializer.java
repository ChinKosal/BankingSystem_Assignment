package com.bank.BankingSystem.config;

import com.bank.BankingSystem.entity.Role;
import com.bank.BankingSystem.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DatabaseInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) {
        // Initialize default roles if they don't exist
        if (!roleRepository.findByName("USER").isPresent()) {
            Role userRole = new Role();
            userRole.setName("USER");
            roleRepository.save(userRole);
        }

        // Optionally, you can also create an ADMIN role
        if (!roleRepository.findByName("ADMIN").isPresent()) {
            Role adminRole = new Role();
            adminRole.setName("ADMIN");
            roleRepository.save(adminRole);
        }
    }
}

