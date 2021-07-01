package com.techelevator.tenmo.services;

import com.techelevator.tenmo.auth.models.User;
import com.techelevator.tenmo.models.Account;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class AccountService {
    /*
    This is going to encapsulate API
     */

    private String apiUrl = "http://localhost:8080" ;
    private RestTemplate restTemplate = new RestTemplate();

    public AccountService(String apiUrl){
        this.apiUrl =  apiUrl;
    }

    public List<Account> getAllAccounts(User user){
        System.out.println(user);
        Account[] accounts = restTemplate.getForObject(apiUrl + "/account/"+ user.getId(), Account[].class);
        return Arrays.asList(accounts);

    }
}
