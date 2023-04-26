package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;

import java.util.List;

public interface TransferDao {



    double getBalance(String username);

    int sendMoney(double amount, String username, String sendingUserName);

    List<Transfer> seeTransfer();
    Transfer findTransferByTransferId(int id);
    boolean requestMoney(double amount, String username);
    List<Transfer> seePending();
    boolean approveRequest();

}
