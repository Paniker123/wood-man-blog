package com.woodman.woodmanblog.dto.responseDto;

public class ResponseUserCredential {

    private String token;

    private String tokenType = "Bearer";

    public ResponseUserCredential() {
    }

    public ResponseUserCredential( String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}
