package com.example.apemain.controller;

import com.example.apemain.domains.UserProfileDate;
import com.example.apemain.domains.returns.UserData;
import com.example.apemain.domains.returns.UserSaleData;
import com.example.apemain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;

    @GetMapping("")
    public ResponseEntity<List<UserData>> allusers(){
        return ResponseEntity.ok(userService.getAllUser());
    }

    @GetMapping("/{email}/{pass}")
    public ResponseEntity<Integer> isUserLogdIn(@PathVariable String email, @PathVariable String pass){
        return ResponseEntity.ok(userService.isLogIn(email,pass));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserProfileDate> getUserDate(@PathVariable int userId){
        return ResponseEntity.ok(userService.getUserDate(userId));
    }

    @GetMapping("/sale/{userId}")
    public ResponseEntity<List<UserSaleData>> getUserSaleDate(@PathVariable int userId){
        return ResponseEntity.ok(userService.getUserSaleDate(userId));
    }
}
