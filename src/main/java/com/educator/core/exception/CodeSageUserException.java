package com.educator.core.exception;

import lombok.Getter;

@Getter
public class CodeSageUserException extends RuntimeException {

    private static final String MESSAGE = "User exception thrown";

    private String userMessage;

    public static CodeSageUserException withUserMessage(String userMessage) {
        CodeSageUserException ex = new CodeSageUserException(MESSAGE + ": " + userMessage);
        ex.userMessage = userMessage;
        return ex;
    }

    private CodeSageUserException(String message) {
        super(message);
    }

}
