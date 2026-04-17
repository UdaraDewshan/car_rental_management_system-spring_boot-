package edu.icet.controller;

import edu.icet.model.dto.AuthRequest;
import edu.icet.model.dto.AuthResponse;
import edu.icet.model.dto.RegisterRequest;
import edu.icet.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth") // මේක තමයි අපි SecurityConfig එකේ permitAll() දුන්නේ
@RequiredArgsConstructor
@CrossOrigin // React එකෙන් එන Request block නොවී තියෙන්න මේක අනිවාර්යයි
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}