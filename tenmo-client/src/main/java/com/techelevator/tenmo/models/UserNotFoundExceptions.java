package com.techelevator.tenmo.models;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UserNotFoundExceptions {

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "username not found.")
    public class UserNotFoundException extends RuntimeException {


        private static final long serialVersionUID = 1L;

        public UserNotFoundException() {
            super("user not found.");
        }


    }
}
