package com.woodman.woodmanblog.service;

import com.woodman.woodmanblog.dto.requestDto.LoggingUser;
import com.woodman.woodmanblog.dto.requestDto.RegisterUserRequest;
import com.woodman.woodmanblog.dto.responseDto.ApiResponse;
import com.woodman.woodmanblog.dto.responseDto.ResponseUserCredential;
import com.woodman.woodmanblog.exception.BadRequestException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends UserDetailsService {

    ApiResponse createNewUser(RegisterUserRequest registerUserRequest) throws BadRequestException;

    ResponseUserCredential logging(LoggingUser name) throws UsernameNotFoundException;

    UserDetails loggingById(Long id) throws UsernameNotFoundException;

}
