package com.techelevator.tenmo.services;

import com.techelevator.tenmo.auth.models.User;
import com.techelevator.tenmo.models.Account;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class UserService {

    public static String AUTH_TOKEN = "";
    private String apiUrl = "http://localhost:8080" ;
    private RestTemplate restTemplate = new RestTemplate();

    public UserService(String apiUrl) {
        this.apiUrl = apiUrl;

    }

    public List<User> getAllUsers(User user){

       User[] users = restTemplate.getForObject(apiUrl + "/user/"+ user.getId(), User[].class);
       return Arrays.asList(users);

    }
}
