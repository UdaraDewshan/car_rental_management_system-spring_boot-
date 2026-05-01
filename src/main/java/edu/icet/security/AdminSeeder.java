package edu.icet.security;

import edu.icet.model.entity.User;
import edu.icet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AdminSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        if (userRepository.findByEmail("admin@cardirect.com").isEmpty()) {

            User admin = new User();
            admin.setUserId(UUID.randomUUID().toString());
            admin.setUserName("System Admin");
            admin.setEmail("admin@cardirect.com");
            admin.setPhoneNumber("0777000000");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole("ADMIN");

            userRepository.save(admin);
            System.out.println("System Admin Created Successfully!");
        } else {
            System.out.println("System Admin already exists.");
        }
    }
}