package com.example.apemain.controller;

import com.example.apemain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/{email}/{pass}")
    public ResponseEntity<Integer> isUserLogdIn(@PathVariable String email, @PathVariable String pass){
        return ResponseEntity.ok(userService.isLogIn(email,pass));
    }
}
