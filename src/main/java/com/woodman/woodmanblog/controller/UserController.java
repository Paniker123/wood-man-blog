package com.woodman.woodmanblog.controller;

import com.woodman.woodmanblog.dto.requestDto.LoggingUser;
import com.woodman.woodmanblog.dto.requestDto.RegisterUserRequest;
import com.woodman.woodmanblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService mUserService;


    @PostMapping("/register")
    public ResponseEntity<?> createNewUser(@RequestBody RegisterUserRequest registerUserRequest) {
        return ResponseEntity.created(
                ServletUriComponentsBuilder
                        .fromCurrentRequestUri().path("/api/users/welcome")
                        .build()
                        .toUri())
                .body(mUserService.createNewUser(registerUserRequest));
    }


    @PostMapping("/logging")
    public ResponseEntity<?> logging(@Valid @RequestBody LoggingUser loggingUser) {
        return ResponseEntity.ok(mUserService.logging(loggingUser));
    }

    @GetMapping("")
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public ResponseEntity getAllUsers() {

        return ResponseEntity.noContent().build();
    }

}
