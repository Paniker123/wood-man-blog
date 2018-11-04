package com.woodman.woodmanblog.util;

public enum ErrorResponseCode {
    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    NOT_FOUND(404),
    METHOD_NOT_ALLOWED(405);

    int code;

    ErrorResponseCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
