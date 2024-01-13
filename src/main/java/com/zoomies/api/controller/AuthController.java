package com.zoomies.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zoomies.api.model.User;
import com.zoomies.api.model.dto.LoginDto;
import com.zoomies.api.model.dto.RegisterDto;
import com.zoomies.api.service.impl.AuthService;
import com.zoomies.api.util.ResponseUtil;

@RequestMapping("/auth")
public class AuthController {

    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<User> login(@Validated @RequestBody LoginDto loginDto) {
        User user = authService.login(loginDto);
        return ResponseUtil.success(user);
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@Validated @RequestBody RegisterDto registerDto) {
        User user = authService.register(registerDto);
        return ResponseUtil.success(user);
    }

}
