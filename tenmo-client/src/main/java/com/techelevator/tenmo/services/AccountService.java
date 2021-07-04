package com.techelevator.tenmo.services;

import com.techelevator.tenmo.auth.models.User;
import com.techelevator.tenmo.models.Account;
import io.cucumber.java.en_old.Ac;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.ArrayList;
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

  /*  public List<Account> getAllAccounts(User user) {
        Account account = new Account();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(AUTH_TOKEN);
        HttpEntity<Account> entity = new HttpEntity<>(account, headers);
        try {
            String url = apiUrl + "/account/" + user.getId();
            account = restTemplate.exchange(url, HttpMethod.GET, entity, Account.class).getBody();
        } catch (RestClientResponseException e){

        }
        return Arrays.asList(account);

    }
*/
    public List<Account> getAllAccounts(User user){


        Account[] accounts = restTemplate.getForObject(apiUrl + "/account/"+ user.getId(), Account[].class);
        return Arrays.asList(accounts);

    }
}
