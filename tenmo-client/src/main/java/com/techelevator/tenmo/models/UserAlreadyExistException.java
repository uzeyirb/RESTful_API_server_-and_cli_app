package com.techelevator.tenmo.models;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UserAlreadyExistException {

    @ResponseStatus (code = HttpStatus.NOT_FOUND, reason = "User Already Exists.")
    public class userAlreadyExistsException extends RuntimeException {
        private static final long serialVersionUID = 1L;
        public userAlreadyExistsException () {
            super("User Already Exists.");
        }
    }
}
