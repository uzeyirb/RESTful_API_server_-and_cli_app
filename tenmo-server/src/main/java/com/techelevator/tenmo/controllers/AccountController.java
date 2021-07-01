package com.techelevator.tenmo.controllers;

import com.techelevator.tenmo.daos.AccountDAO;
import com.techelevator.tenmo.models.Account;
import com.techelevator.tenmo.models.Transfer;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.ArrayList;
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
        System.out.println(transfer);
        return accountDAO.transfer(transfer);
    }


    /*@RequestMapping(path = "account/filter", method = RequestMethod.GET)
    public List<Account> filterByUser(@RequestParam long id){
        List<Account> filteredAccount = new ArrayList<>();
        List<Account> accounts = list();
        for (Account acc: accounts){
            if(id != 0){
                if(acc.)

            }
        }
    }*/

}
