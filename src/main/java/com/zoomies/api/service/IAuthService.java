package com.zoomies.api.service;

import com.zoomies.api.exceptions.BadRequestException;
import com.zoomies.api.exceptions.InternalException;
import com.zoomies.api.exceptions.NotFoundException;
import com.zoomies.api.exceptions.UnauthorizedException;
import com.zoomies.api.model.User;
import com.zoomies.api.model.dto.LoginDto;
import com.zoomies.api.model.dto.RegisterDto;

public interface IAuthService {
    User login(LoginDto loginDto) throws NotFoundException, UnauthorizedException, InternalException;

    User register(RegisterDto registerDto) throws BadRequestException, InternalException;
}