package com.woodman.woodmanblog.controller;


import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class AdviceExceptionController extends ResponseEntityExceptionHandler {
//
//    @ExceptionHandler(value
//            = {IllegalArgumentException.class, IllegalStateException.class})
//    protected ResponseEntity<?> handleConflict(RuntimeException ex, WebRequest request, ErrorResponseCode errorCode, String message) {
//        return handleExceptionInternal(ex, new ErrorResponse(errorCode, message), new HttpHeaders(), HttpStatus.CONFLICT, request);
//    }
//
//    @ExceptionHandler(value = NotFoundException.class)
//    protected ResponseEntity<?> handleNotFound(NotFoundException exception, WebRequest request) {
//        return handleExceptionInternal(
//                exception,
//                new ErrorResponse(ErrorResponseCode.NOT_FOUND, exception.getMessage()),
//                new HttpHeaders(),
//                HttpStatus.NOT_FOUND,
//                request);
//    }
//
//    @ExceptionHandler(value = BadRequestException.class)
//    protected ResponseEntity<?> handleBadRequest(BadRequestException exception, WebRequest request) {
//        return handleExceptionInternal(
//                exception,
//                new ErrorResponse(ErrorResponseCode.BAD_REQUEST, exception.getMessage()),
//                new HttpHeaders(),
//                HttpStatus.BAD_REQUEST, request);
//    }
//
//    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
//    protected ResponseEntity<?> handleMathosNotAllowed(HttpRequestMethodNotSupportedException exception, WebRequest request) {
//        return handleExceptionInternal(
//                exception,
//                new ErrorResponse(ErrorResponseCode.METHOD_NOT_ALLOWED, exception.getMessage()),
//                new HttpHeaders(),
//                HttpStatus.METHOD_NOT_ALLOWED, request);
//    }

//    @ExceptionHandler(value = HttpMediaTypeNotAcceptableException.class)
//    protected ResponseEntity<?> handleMedicaTypeNotAcceptable(HttpMediaTypeNotAcceptableException exception, WebRequest request) {
//        return handleExceptionInternal(
//                exception,
//                new ErrorResponse(ErrorResponseCode.UNSUPPORTED_MEDIA_TYPE.getErrorCode(), exception.getMessage()),
//                new HttpHeaders(),
//                HttpStatus.UNSUPPORTED_MEDIA_TYPE, request);
//    }
//
//    @ExceptionHandler(value = .class)
//    protected ResponseEntity<?> handleForbiddenTargetException(ForbiddenTargetException exception, WebRequest request) {
//        return handleExceptionInternal(
//                exception,
//                new ErrorResponse(ErrorResponseCode.FORBIDDEN.getErrorCode(), exception.getMessage()),
//                new HttpHeaders(),
//                HttpStatus.FORBIDDEN, request);
//    }

//    @ExceptionHandler(value = ExecutionControl.InternalException.class)
//    protected ResponseEntity<?> handleInternalException(ExecutionControl.InternalException exception, WebRequest request) {
//        return handleExceptionInternal(
//                exception,
//                new ErrorResponse(ErrorResponseCode.INTERNAL_SERVER_ERROR.getErrorCode(), exception.getMessage()),
//                new HttpHeaders(),
//                HttpStatus.INTERNAL_SERVER_ERROR, request);
//    }
}
