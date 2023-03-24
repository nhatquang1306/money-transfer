package com.techelevator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankCustomer implements Accountable{
    private String name;
    private String address;
    private String phoneNumber;
    private List<Accountable> accounts = new ArrayList<>();

    @Override
    public int getBalance() {
        return 0;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Accountable[] getAccounts() {
        Accountable[] arrayOfAccounts = new Accountable[accounts.size()]; //created new array and set it size
        accounts.toArray(arrayOfAccounts); // add the accounts from the list to the array and populate array using the accounts
        return arrayOfAccounts; //return the new array
}
    public void addAccount (Accountable newAccount) {
        accounts.add(newAccount);
    }
    public boolean isVip() {
       int totalBalance = 0; //Created integer to represent the total bank account balance
       for (Accountable account : accounts) { //For each account we're checking the total balance
           totalBalance += account.getBalance(); //Adding the accounts together with each other
       }
       return totalBalance >= 25000; //Returns true if sum is at least 25k of all accounts
        }
}
