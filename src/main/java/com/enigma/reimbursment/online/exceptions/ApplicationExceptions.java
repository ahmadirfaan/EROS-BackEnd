package com.enigma.reimbursment.online.exceptions;

import org.springframework.http.HttpStatus;

public class ApplicationExceptions extends RuntimeException {
    private final HttpStatus status;

    public ApplicationExceptions(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
