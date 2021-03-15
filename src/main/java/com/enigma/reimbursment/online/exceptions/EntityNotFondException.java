package com.enigma.reimbursment.online.exceptions;

import org.springframework.http.HttpStatus;

public class EntityNotFondException extends ApplicationException {

    public EntityNotFondException() {
        super(HttpStatus.NOT_FOUND, "error." + HttpStatus.NOT_FOUND.value() + ".entity");
    }

}
