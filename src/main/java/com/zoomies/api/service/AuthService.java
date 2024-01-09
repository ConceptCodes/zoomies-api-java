package com.zoomies.api.service;

import com.zoomies.api.exceptions.BadRequestException;
import com.zoomies.api.exceptions.InternalException;
import com.zoomies.api.exceptions.NotFoundException;
import com.zoomies.api.exceptions.UnauthorizedException;
import com.zoomies.api.model.User;
import com.zoomies.api.model.dto.LoginDto;
import com.zoomies.api.model.dto.RegisterDto;
import com.zoomies.api.repository.UserRepository;

public class AuthService {

    private UserRepository userRepository;

    public User login(LoginDto loginDto) throws NotFoundException, UnauthorizedException, InternalException {
        try {
            Boolean existsByEmail = userRepository.existsByEmail(loginDto.getEmail());
            if (!existsByEmail) {
                throw new NotFoundException("User not found");
            }
            User user = userRepository.findByEmail(loginDto.getEmail());
            if (!user.getPassword().equals(loginDto.getPassword())) {
                throw new UnauthorizedException("Email or password incorrect");
            }
            return user;
        } catch (Exception e) {
            if (e instanceof NotFoundException || e instanceof UnauthorizedException) {
                throw e;
            } else {
                throw new InternalException("Internal server error");
            }
        }
    }

    public User register(RegisterDto registerDto) throws BadRequestException, InternalException {
        try {
            Boolean existsByEmail = userRepository.existsByEmail(registerDto.getEmail());
            if (existsByEmail) {
                throw new BadRequestException("Email already exists");
            }
            User user = new User();
            user.setEmail(registerDto.getEmail());
            user.setPassword(registerDto.getPassword()); // TODO: hash password
            user.setFullName(registerDto.getFullName());
            return userRepository.save(user);
        } catch (Exception e) {
            if (e instanceof BadRequestException) {
                throw e;
            } else {
                throw new InternalException("Internal server error");
            }
        }
    }

}
