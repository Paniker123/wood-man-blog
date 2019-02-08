package com.woodman.woodmanblog.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {

    @GetMapping("")
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public ResponseEntity getAllUsers() {

        return ResponseEntity.noContent().build();
    }

}
