package com.woodman.woodmanblog.dto.requestDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoggingUser {

    @NotNull
    @NotBlank
    private String userName;

    @NotNull
    @NotBlank
    @Size(min = 6)
    private String password;

    public LoggingUser() {
    }

    public LoggingUser(@NotNull @NotBlank String userName, @NotNull @NotBlank @Size(min = 6) String password) {
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
