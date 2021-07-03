package com.techelevator.tenmo.daos;

import com.techelevator.tenmo.models.Account;
import com.techelevator.tenmo.models.Transfer;

import java.util.List;

public interface AccountDAO {
    List<Account> list();
    List<Account> getAllAccountByUser(long userId);
    Account getUserAccount(String username);
    Account get(long id);
    Account transfer(Transfer transfer);
    Account updateBalance(long accountId, Double amount);
    List<Account> getAllAccountExceptSender(long userId);
}
