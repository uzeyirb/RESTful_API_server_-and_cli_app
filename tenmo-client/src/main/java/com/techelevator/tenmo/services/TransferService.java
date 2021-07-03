package com.techelevator.tenmo.services;

import com.techelevator.tenmo.auth.models.User;
import com.techelevator.tenmo.models.Account;
import com.techelevator.tenmo.models.Transfer;
import io.cucumber.java.bs.A;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class TransferService {

    private String apiUrl = "http://localhost:8080" ;
    private RestTemplate restTemplate = new RestTemplate();

    public TransferService(String apiUrl){
        this.apiUrl =  apiUrl;
    }

/*
    public List<Account> getListForTransfer(User user){
        System.out.println(user); // delete these after done
        Account[] accounts = restTemplate.getForObject(apiUrl +"/account/" + user.getId(), Account[].class);
        return Arrays.asList(accounts);
    }*/

    public Account transfer(Transfer transfer){
        Account account = restTemplate.postForObject(apiUrl + "/account/transfer", transfer,  Account.class);
        return account;
    }

}
