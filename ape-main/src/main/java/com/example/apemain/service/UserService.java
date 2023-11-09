package com.example.apemain.service;

import com.example.apemain.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final
    UserRepository userRepository;
    public
    Integer isLogIn(String email, String pass) {
        try {
            return userRepository.logIn(email,pass);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
