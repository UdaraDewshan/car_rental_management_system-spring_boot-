package edu.icet.service;

import edu.icet.model.dto.AuthRequest;
import edu.icet.model.dto.AuthResponse;
import edu.icet.model.dto.RegisterRequest;
import edu.icet.model.entity.User;
import edu.icet.repository.UserRepository;
import edu.icet.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {
        User user = new User();
        user.setUserId(UUID.randomUUID().toString());
        user.setUserName(request.getUserName());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("CUSTOMER");

        repository.save(user);

        String jwtToken = jwtService.generateToken(user);
        return new AuthResponse(jwtToken,user.getRole());
    }

    public AuthResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = repository.findByEmail(request.getEmail()).orElseThrow();

        String jwtToken = jwtService.generateToken(user);
        return new AuthResponse(jwtToken,user.getRole());
    }
}