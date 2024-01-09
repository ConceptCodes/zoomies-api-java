package com.zoomies.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zoomies.api.model.User;
import com.zoomies.api.model.dto.LoginDto;
import com.zoomies.api.model.dto.RegisterDto;
import com.zoomies.api.service.AuthService;

@RequestMapping("/auth")
public class AuthController {

    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<User> login(@Validated @RequestBody LoginDto loginDto) {
        try {
            User user = authService.login(loginDto);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@Validated @RequestBody RegisterDto registerDto) {
        try {
            User user = authService.register(registerDto);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
