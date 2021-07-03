package com.techelevator.tenmo.controllers;

import com.techelevator.tenmo.daos.AccountDAO;
import com.techelevator.tenmo.models.Account;
import com.techelevator.tenmo.models.Transfer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@PreAuthorize("isAuthenticated()")
@RestController
public class AccountController {
   private AccountDAO accountDAO;


    public AccountController(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    //@RequestMapping
    //@PreAuthorize("hasRole('USER')")
   // @PreAuthorize("admitAll")
   /* @RequestMapping(path = "/account" , method = RequestMethod.GET)
    public List<Account> list() {
        return accountDAO.list();

    }*/
    //@PreAuthorize("admitAll")

    @RequestMapping(path = "/account/{userId}", method = RequestMethod.GET)
    private List<Account> get(@PathVariable long userId){

        return accountDAO.getAllAccountByUser(userId);
    }

    @RequestMapping(path = "/account/transfer", method = RequestMethod.POST)
    public Account transfer(@RequestBody Transfer transfer){
        return accountDAO.transfer(transfer);
    }

    /*@RequestMapping(path = "/account/{userId}", method = RequestMethod.GET)
    private List<Account> get(@PathVariable long userId){

        return accountDAO.getAllAccountByUser(userId);
    }*/


}
