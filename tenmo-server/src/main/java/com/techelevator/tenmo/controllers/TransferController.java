/*

package com.techelevator.tenmo.controllers;
import com.techelevator.tenmo.daos.AccountDAO;
import com.techelevator.tenmo.models.Account;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransferController {
    private AccountDAO accountDAO;

    public TransferController(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @RequestMapping(path = "/account/{userId}" , method = RequestMethod.GET)
    private List<Account> getListForTransfer(@PathVariable long userId){
        return accountDAO.getAllAccountExceptSender(userId);
        }


}
*/
