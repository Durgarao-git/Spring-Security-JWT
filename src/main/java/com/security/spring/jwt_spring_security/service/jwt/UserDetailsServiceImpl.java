package com.security.spring.jwt_spring_security.service.jwt;

import com.security.spring.jwt_spring_security.entity.User;
import com.security.spring.jwt_spring_security.repository.UserRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService {

    @Autowired
    private UserRepositoty userRepositoty;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user=userRepositoty.findFirstByEmail(email);

        if(user == null){
            throw new UsernameNotFoundException("User not found",null);
        }
        return new (user.getEmail(),user.getPassword(),new ArrayList<>());
    }
}
