package com.techelevator.tenmo.services;

import com.techelevator.tenmo.auth.models.User;
import com.techelevator.tenmo.models.Account;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

public class AccountService {
    /*
    This is going to encapsulate API
     */
    public static String AUTH_TOKEN = "";
    private String apiUrl = "http://localhost:8080" ;
    private RestTemplate restTemplate = new RestTemplate();



    public AccountService(String apiUrl){
        this.apiUrl =  apiUrl;
    }

    public List<Account> getAllAccounts(User user){


  /*      HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(AUTH_TOKEN);  // set the token
        HttpEntity <Account> entity = new HttpEntity<Account>(account, headers);*/
        Account[] accounts = restTemplate.getForObject(apiUrl + "/account/"+ user.getId(), Account[].class);
        return Arrays.asList(accounts);

    }
}
