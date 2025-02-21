package com.security.spring.jwt_spring_security.dto;


public class AuthenticationResponse {

    private String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public AuthenticationResponse() {
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    @Override
    public String toString() {
        return "AuthenticationResponse{" +
                "jwt='" + jwt + '\'' +
                '}';
    }
}
