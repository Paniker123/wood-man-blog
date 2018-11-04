package com.woodman.woodmanblog.dto.responseDto;

import com.woodman.woodmanblog.util.ErrorResponseCode;

public class ErrorResponse {

    private ErrorResponseCode statusCode;

    private String message;

    public ErrorResponse() {
    }

    public ErrorResponse(ErrorResponseCode statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public ErrorResponseCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(ErrorResponseCode statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
