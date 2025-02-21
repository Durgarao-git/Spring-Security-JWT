package com.security.spring.jwt_spring_security.repository;

import com.security.spring.jwt_spring_security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoty extends JpaRepository<User,Long> {
    User findFirstByEmail(String email);
}
