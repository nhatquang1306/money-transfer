package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;

import java.util.List;

public interface TransferDao {



    double getBalance(String username);

    Transfer sendMoney(double amount, String username, String receivingUsername);

    List<Transfer> seeTransfer(String username);
    Transfer findTransferByTransferId(String username, int id);
    Transfer requestMoney(double amount, String username, String receivingUsername);
    List<Transfer> seePending(String username);
    Transfer approveRequest(String username, int id, String status);

}
