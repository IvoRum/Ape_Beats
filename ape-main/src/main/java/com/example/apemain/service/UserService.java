package com.example.apemain.service;

import com.example.apemain.domains.UserProfileDate;
import com.example.apemain.domains.returns.UserData;
import com.example.apemain.domains.returns.UserSaleData;
import com.example.apemain.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public UserProfileDate getUserDate(int userId) {

        try {
            return userRepository.getUser(userId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public List<UserSaleData> getUserSaleDate(int userId) {
        try {
            return userRepository.getUserSales(userId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<UserData> getAllUser() {
        try {
            return userRepository.getAllUsers();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
