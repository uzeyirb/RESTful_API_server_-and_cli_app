package com.techelevator.tenmo.view;

import com.techelevator.tenmo.models.Account;
import com.techelevator.tenmo.services.AccountService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class AccountServiceTest {
    private AccountService service;


    @Before
    public void setup(){
        service = new AccountService("http://localhost:8080/");

    }

    @Test
    public void get_all_contacts(){
        List<Account> accounts = service.getAllAccounts();
        Assert.assertTrue(accounts.size() > 0);
    }

}
