package com.woodman.woodmanblog.dto.requestDto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoggingUser {

    @JsonProperty("user_name")
    @NotNull
    @NotBlank
    private String userName;

    @JsonProperty("password")
    @NotNull
    @NotBlank
    @Size(min = 6)
    private String password;

    public LoggingUser() {
    }

    public LoggingUser(String userName,String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
