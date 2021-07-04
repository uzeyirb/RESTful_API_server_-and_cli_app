package com.techelevator.tenmo.controllers;

import com.techelevator.tenmo.daos.AccountDAO;
import com.techelevator.tenmo.models.Account;
import com.techelevator.tenmo.models.Transfer;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@PreAuthorize("isAuthenticated()")
@RestController
public class AccountController {
   private AccountDAO accountDAO;


    public AccountController(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    //@PreAuthorize("admitAll")
    @RequestMapping(path = "/account/{userId}", method = RequestMethod.GET)
    private List<Account> get(@PathVariable long userId){

        return accountDAO.getAllAccountByUser(userId);
    }

    @RequestMapping(path = "/account/transfer", method = RequestMethod.POST)
    public Account transfer(@RequestBody Transfer transfer){
        return accountDAO.transfer(transfer);
    }

   }
