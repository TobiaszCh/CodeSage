package com.educator.core.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CodeSageUserException extends RuntimeException {

    private static final String MESSAGE = "User exception thrown";

    private HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

    private String userMessage;

    public static CodeSageUserException withUserMessage(String userMessage) {
        return withUserMessage(userMessage, HttpStatus.BAD_REQUEST);
    }

    public static CodeSageUserException withUserMessage(String userMessage, HttpStatus httpStatus) {
        CodeSageUserException ex = new CodeSageUserException(MESSAGE + ": " + userMessage);
        ex.userMessage = userMessage;
        return ex;
    }

    private CodeSageUserException(String message) {
        super(message);
    }

}
