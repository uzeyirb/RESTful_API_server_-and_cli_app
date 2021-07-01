package com.techelevator.tenmo.daos;

import com.techelevator.tenmo.models.Account;

import java.util.List;

public interface AccountDAO {
    List<Account> getAllAccount();
    List<Account> getAllAccountByUser(long userId);
    Account getUserAccount(String username);
}
