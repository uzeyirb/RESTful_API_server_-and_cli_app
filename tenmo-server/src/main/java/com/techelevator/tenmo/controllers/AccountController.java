package com.techelevator.tenmo.controllers;

import com.techelevator.tenmo.daos.AccountDAO;
import com.techelevator.tenmo.models.Account;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@PreAuthorize("isAuthorized()")
@RestController
public class AccountController {
    AccountDAO jdbcAccountDAO;


    public AccountController(AccountDAO jdbcAccountDAO) {
        this.jdbcAccountDAO = jdbcAccountDAO;
    }

    //@RequestMapping
    @PreAuthorize("hasRole")
    @GetMapping ("/account/{userId}")
    public List<Account> getListOfAccounts(@RequestHeader ("userId") long userId){
             return   jdbcAccountDAO.getAllAccountByUser(userId);

    }


}
