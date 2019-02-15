package com.woodman.woodmanblog.controller;

import com.woodman.woodmanblog.dto.requestDto.LoggingUser;
import com.woodman.woodmanblog.dto.requestDto.RegisterUserRequest;
import com.woodman.woodmanblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService mUserService;

    @PostMapping("/signUp")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterUserRequest registerUserRequest) {
        return ResponseEntity.ok(mUserService.createNewUser(registerUserRequest));
    }

    @PostMapping("/signIn")
    public ResponseEntity<?> signIn(@Valid @RequestBody LoggingUser loggingUser) {
        return ResponseEntity.ok(mUserService.signIn(loggingUser));
    }
}
