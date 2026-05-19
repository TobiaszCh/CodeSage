package com.educator.controller;

import com.educator.core.exception.CodeSageRuntimeException;
import com.educator.core.exception.CodeSageUserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String DEFAULT_SYSTEM_ERROR_METHOD = "Wystąpił nieoczekiwany błąd systemu";

    @ExceptionHandler(CodeSageRuntimeException.class)
    public ResponseEntity<Map<String, String>> handlerCodeSageRuntimeException(CodeSageRuntimeException ex) {
        log.warn("Application runtime exception", ex);
        return new ResponseEntity<>(Map.of("inform", DEFAULT_SYSTEM_ERROR_METHOD), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CodeSageUserException.class)
    public ResponseEntity<Map<String, String>> handlerCodeSageUserException(CodeSageUserException ex) {
        log.warn("Business validation failed", ex);
        return new ResponseEntity<>(Map.of("message", ex.getUserMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<Map<String, String>> handlerEmptyResultDataAccessException(EmptyResultDataAccessException ex) {
        return new ResponseEntity<>(Map.of("message", ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<ObjectError> results = ex.getBindingResult().getAllErrors();
        if (results.isEmpty()) {
            throw new CodeSageRuntimeException("Lack of validation errors - it shouldn't happen!");
        }
        String message = results.get(0).getDefaultMessage();
        if (message == null) {
            throw new CodeSageRuntimeException("Message can't be null");
        }
        return new ResponseEntity<>(Map.of("message", message), HttpStatus.BAD_REQUEST);
    }
}
