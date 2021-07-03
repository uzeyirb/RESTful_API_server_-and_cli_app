package com.techelevator.tenmo.auth.controller;

import com.techelevator.tenmo.auth.dao.UserDAO;
import com.techelevator.tenmo.auth.model.User;
import com.techelevator.tenmo.daos.AccountDAO;
import com.techelevator.tenmo.models.Account;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private UserDAO userDAO;

    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @RequestMapping(path = "/user/{userId}", method = RequestMethod.GET)
    private List<User> getAllExceptUser(@PathVariable long userId){
        return userDAO.findAllExceptUser(userId);
    }
}
