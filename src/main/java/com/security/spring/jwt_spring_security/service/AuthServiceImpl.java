package com.security.spring.jwt_spring_security.service;

import com.security.spring.jwt_spring_security.dto.SignUpRequest;
import com.security.spring.jwt_spring_security.dto.UserDto;
import com.security.spring.jwt_spring_security.entity.User;
import com.security.spring.jwt_spring_security.repository.UserRepositoty;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private UserRepositoty userRepositoty;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(SignUpRequest signUpRequest) {

        User user= modelMapper.map(signUpRequest,User.class);
        user.setPassword(new BCryptPasswordEncoder().encode(signUpRequest.getPassword()));
        User savedUser=userRepositoty.save(user);
        return (modelMapper.map(savedUser,UserDto.class));
    }
}
