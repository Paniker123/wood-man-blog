package com.woodman.woodmanblog.controller;

import com.woodman.woodmanblog.dto.requestDto.LoggingUser;
import com.woodman.woodmanblog.dto.requestDto.RegisterUserRequest;
import com.woodman.woodmanblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService mUserService;


    @PostMapping("/register")
    public ResponseEntity<?> createNewUser(@RequestBody RegisterUserRequest registerUserRequest) {
        return ResponseEntity.ok(mUserService.createNewUser(registerUserRequest));
    }


    @PostMapping
    public ResponseEntity<?> logging(@Valid @RequestBody LoggingUser loggingUser) {
        return ResponseEntity.ok(mUserService.logging(loggingUser));
    }

    @GetMapping("")
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public ResponseEntity getAllUsers() {

        return ResponseEntity.noContent().build();
    }

}
