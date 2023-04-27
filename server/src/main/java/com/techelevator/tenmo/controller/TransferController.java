package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.JdbcTransferDao;
import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@Component
@RestController
@PreAuthorize("isAuthenticated()")
public class TransferController {
    @Autowired
    JdbcTransferDao transferDao;

    @RequestMapping(path = "balance", method = RequestMethod.GET)
    public double getBalance(Principal principal) {
        return transferDao.getBalance(principal.getName());
    }

    @RequestMapping(path = "send/{username}/{amount}", method = RequestMethod.POST)
    public Transfer sendMoney(Principal principal, @PathVariable double amount, @PathVariable String username) {
        Transfer transfer = transferDao.sendMoney(amount, principal.getName(), username);
        if (transfer == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Transfer Failed");
        } else {
            return transfer;
        }
    }
    @RequestMapping(path = "transfers", method = RequestMethod.GET)
    public List<Transfer> transferList(Principal principal){
        return transferDao.seeTransfer(principal.getName());
    }
    @RequestMapping(path = "transfers/{id}", method = RequestMethod.GET)
    public Transfer getTransferById(@PathVariable int id, Principal principal){
        Transfer transfer = transferDao.findTransferByTransferId(principal.getName(), id);
        if (transfer == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No access to transfer.");
        } else {
            return transfer;
        }
    }
    @RequestMapping(path = "request/{username}/{amount}", method = RequestMethod.POST)
    public Transfer requestMoney(Principal principal, @PathVariable String username, @PathVariable double amount) {
        Transfer transfer = transferDao.requestMoney(amount, username, principal.getName());
        if (transfer == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request Failed");
        } else {
            return transfer;
        }
    }
    @RequestMapping(path = "transfers/pending", method = RequestMethod.GET)
    public List<Transfer> seePending(Principal principal) {
        return transferDao.seePending(principal.getName());
    }
    @RequestMapping(path = "approve/{id}/{status}", method = RequestMethod.PUT)
    public Transfer approveRequest(Principal principal, @PathVariable int id, @PathVariable String status){
        Transfer transfer = transferDao.approveRequest(principal.getName(), id, status);
        if (transfer == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Incorrect Input Or Insufficient Funds.");
        } else {
            return transfer;
        }
    }
}
