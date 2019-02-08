package com.woodman.woodmanblog.service.impl;

import com.woodman.woodmanblog.dao.entity.User;
import com.woodman.woodmanblog.dao.enumObjects.RoleName;
import com.woodman.woodmanblog.dao.repository.RoleRepository;
import com.woodman.woodmanblog.dao.repository.UserRepository;
import com.woodman.woodmanblog.dto.requestDto.LoggingUser;
import com.woodman.woodmanblog.dto.requestDto.RegisterUserRequest;
import com.woodman.woodmanblog.dto.responseDto.ApiResponse;
import com.woodman.woodmanblog.dto.responseDto.ResponseUserCredential;
import com.woodman.woodmanblog.exception.BadRequestException;
import com.woodman.woodmanblog.security.JwtTokenProvider;
import com.woodman.woodmanblog.security.UserPrincipal;
import com.woodman.woodmanblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository mUserRepository;

    @Autowired
    private RoleRepository mRoleRepository;

    @Autowired
    private AuthenticationManager mAuthenticationManager;

    @Autowired
    private JwtTokenProvider mTokenProvider;

    @Autowired
    private PasswordEncoder mPasswordEncoder;

    /**
     * Default user role is "ROLE_USER"
     */

    @Override
    public ApiResponse createNewUser(RegisterUserRequest registerUserRequest) throws BadRequestException {
        var isUserExists = mUserRepository.findByUserName(registerUserRequest.getUserName());

        if (isUserExists.isPresent()) throw new BadRequestException("This username is already exists!!!");

        if (!registerUserRequest.getUserPassword().equals(registerUserRequest.getConfirmPassword()))
            throw new BadRequestException("Confirm password not same with password!");

        var userRole = mRoleRepository.findByRoleName(RoleName.ROLE_USER).orElseThrow(() -> new BadRequestException("User roles not found"));

        var encryptingString = mPasswordEncoder.encode(registerUserRequest.getUserPassword());

        var user=mUserRepository.save(new User(registerUserRequest.getUserName(),encryptingString, Collections.singleton(userRole)));

        return new ApiResponse("User "+user.getUserName()+" successfully registered!!!");
    }

    @Override
    public ResponseUserCredential signIn(LoggingUser loggingUser) throws UsernameNotFoundException {
        var authentication = mAuthenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        loggingUser.getUserName(),
                        loggingUser.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new ResponseUserCredential(mTokenProvider.generateToken(authentication));
    }


    @Override
    @Transactional
    public UserDetails loggingById(Long id) throws UsernameNotFoundException {
        var user = mUserRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User by id:[ " + id + " ] not found!"));
        return UserPrincipal.create(user);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = mUserRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User by id:[ " + username + " ] not found!"));
        return UserPrincipal.create(user);
    }
}
