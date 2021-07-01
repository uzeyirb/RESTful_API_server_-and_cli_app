package com.techelevator.tenmo.controllers;

import com.techelevator.tenmo.daos.AccountDAO;
import com.techelevator.tenmo.models.Account;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class AccountController {
   private AccountDAO accountDAO;


    public AccountController(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    //@RequestMapping

    @RequestMapping(path = "/account" , method = RequestMethod.GET)
    public List<Account> getAllAccount() {
        return accountDAO.getAllAccount();

    }


}
