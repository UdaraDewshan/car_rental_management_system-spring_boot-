package edu.icet.controller;

import edu.icet.model.dto.RegisterRequest;
import edu.icet.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@CrossOrigin
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/add")
    public ResponseEntity<String> addAdmin(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(adminService.addAdmin(request));
    }
}