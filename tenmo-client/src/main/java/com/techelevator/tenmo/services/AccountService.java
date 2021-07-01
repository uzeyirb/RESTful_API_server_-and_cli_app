package com.techelevator.tenmo.services;

import com.techelevator.tenmo.models.Account;
import io.cucumber.java.bs.A;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class AccountService {
    /*
    This is going to encapsulate API
     */

    private String apiUrl;
    private RestTemplate restTemplate = new RestTemplate();

    public AccountService(String apiUrl){
        this.apiUrl =  apiUrl;
    }

    public List<Account> getAllAccounts(){
        Account[] accounts = restTemplate.getForObject(apiUrl + "account", Account[].class);
        return Arrays.asList(accounts);

    }
}
