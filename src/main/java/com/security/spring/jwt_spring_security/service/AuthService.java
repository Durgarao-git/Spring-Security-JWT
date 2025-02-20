package com.security.spring.jwt_spring_security.service;

import com.security.spring.jwt_spring_security.dto.SignUpRequest;
import com.security.spring.jwt_spring_security.dto.UserDto;

public interface AuthService {
    UserDto createUser(SignUpRequest signUpRequest);
}
