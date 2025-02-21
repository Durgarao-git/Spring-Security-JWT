package com.security.spring.jwt_spring_security.controller;

import com.security.spring.jwt_spring_security.dto.AuthenticationRequest;
import com.security.spring.jwt_spring_security.dto.AuthenticationResponse;
import com.security.spring.jwt_spring_security.service.jwt.UserDetailsServiceImpl;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    public AuthenticationResponse createAuthToken(@RequestBody AuthenticationRequest authenticationRequest, HttpServletResponse response) throws BadCredentialsException, UsernameNotFoundException, IOException, DisabledException {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),authenticationRequest.getPassword()))

        }catch (BadCredentialsException e){
            throw new BadCredentialsException("Incorrect Username or Password");
        }catch (DisabledException e){
            response.sendError(HttpServletResponse.SC_NOT_FOUND,"User is not created, Register the user first");
            return null;
        }

        final UserDetails userDetails= userDetailsService.loadUserByUsername(authenticationRequest.getEmail())
    }

}
