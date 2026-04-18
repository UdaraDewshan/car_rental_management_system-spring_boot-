package edu.icet.service;

import edu.icet.model.dto.RegisterRequest;
import edu.icet.model.entity.User;
import edu.icet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public String addAdmin(RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return "Error: Email is already registered!";
        }

        User newAdmin = new User();
        newAdmin.setUserId(UUID.randomUUID().toString());
        newAdmin.setUserName(request.getUserName());
        newAdmin.setEmail(request.getEmail());
        newAdmin.setPhoneNumber(request.getPhoneNumber());
        newAdmin.setPassword(passwordEncoder.encode(request.getPassword()));

        newAdmin.setRole("ADMIN");

        userRepository.save(newAdmin);
        return "Admin added successfully!";
    }
}