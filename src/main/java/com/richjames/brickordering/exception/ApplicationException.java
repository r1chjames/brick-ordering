package com.richjames.brickordering.exception;

import lombok.Getter;

@Getter
public class ApplicationException extends RuntimeException {
    private String message;
    private int returnCode;

    public ApplicationException(String message, int returnCode) {
        super(message);
        this.message = message;
        this.returnCode = returnCode;
    }

    public ApplicationException(Throwable cause, String message, int returnCode) {
        super(message, cause);
        this.message = message;
        this.returnCode = returnCode;
    }
}
