
package com.techelevator.tenmo.controllers;

import com.techelevator.tenmo.daos.TransferDAO;
import com.techelevator.tenmo.models.Transfer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransferController {
    private TransferDAO transferDAO;

    public TransferController(TransferDAO transferDAO) {
        this.transferDAO = transferDAO;
    }

    @RequestMapping(path = "/account/transfer", method = RequestMethod.GET)
    private List<Transfer> getListForTransfer() {
        return transferDAO.list();
    }


}
