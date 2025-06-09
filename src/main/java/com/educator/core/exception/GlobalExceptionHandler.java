package com.educator.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CodeSageRuntimeException.class)
    public ResponseEntity<Map<String, String>> handlerCodeSageRuntimeException(CodeSageRuntimeException ex) {
        return new ResponseEntity<>(Map.of("message", ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<ObjectError> results = ex.getBindingResult().getAllErrors();

        if (results.isEmpty()) {
            throw new CodeSageRuntimeException("Brak błędów walidacji - to nie powinno się wydarzyć!");
        }

        String message = results.get(0).getDefaultMessage();
        if (message == null) throw new CodeSageRuntimeException("Message nie może być nulem");

        return new ResponseEntity<>(Map.of("message", message), HttpStatus.BAD_REQUEST);
    }
}
