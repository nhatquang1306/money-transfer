package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.JdbcTransferDao;
import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.Arrays;
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

    @RequestMapping(path = "send", method = RequestMethod.POST)
    public Transfer sendMoney(Principal principal, @RequestBody Transfer transfer) {
        Transfer returnedTransfer = transferDao.sendMoney(principal.getName(), transfer);
        if (returnedTransfer == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Transfer Failed");
        } else {
            return returnedTransfer;
        }
    }
    @RequestMapping(path = "transfers", method = RequestMethod.GET)
    public List<Transfer> transferList(Principal principal){
        return transferDao.seeTransfer(principal.getName());
    }
    @RequestMapping(path = "transfers/{id}", method = RequestMethod.GET)
    public Transfer getTransferById(Principal principal, @PathVariable int id){
        Transfer transfer = transferDao.findTransferByTransferId(principal.getName(), id);
        if (transfer == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No access to transfer.");
        } else {
            return transfer;
        }
    }
    @RequestMapping(path = "request", method = RequestMethod.POST)
    public Transfer requestMoney(Principal principal, @RequestBody Transfer transfer) {
        Transfer returnedTransfer = transferDao.requestMoney(principal.getName(), transfer);
        if (returnedTransfer == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request Failed");
        } else {
            return returnedTransfer;
        }
    }
    @RequestMapping(path = "transfers/pending", method = RequestMethod.GET)
    public List<Transfer> seePending(Principal principal) {
        return transferDao.seePending(principal.getName());
    }
    @RequestMapping(path = "approve/{id}/{status}", method = RequestMethod.PUT)
    public Transfer approveRequest(Principal principal, @PathVariable int id, @PathVariable String status){
        if (status.equals("approve")) {
            status = "Approved";
        } else if (status.equals("reject")) {
            status = "Rejected";
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Incorrect Input.");
        }
        Transfer transfer = transferDao.approveRequest(principal.getName(), id, status);
        if (transfer == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Incorrect Input or Insufficient Funds.");
        } else {
            return transfer;
        }
    }
}
