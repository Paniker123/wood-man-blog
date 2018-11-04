package com.woodman.woodmanblog.dto.requestDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@JsonRootName("User")
public class RegisterUserRequest {

    @JsonProperty("user_name")
    @NotNull
    @NotBlank
    @Size(min = 3)
    private String userName;

    @JsonProperty("password")
    @NotNull
    @NotBlank
    @Size(min = 6)
    private String userPassword;

    @JsonProperty("confirm_password")
    @NotNull
    @NotBlank
    @Size(min = 6)
    private String confirmPassword;

    public RegisterUserRequest(@NotNull @NotBlank @Size(min = 3) String userName, @NotNull @NotBlank @Size(min = 6) String userPassword, @NotNull @NotBlank @Size(min = 6) String confirmPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.confirmPassword = confirmPassword;
    }

    public RegisterUserRequest() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
