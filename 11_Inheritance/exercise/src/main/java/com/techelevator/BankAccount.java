package com.techelevator;

public class BankAccount {
    //instance Variables
    private String accountHolderName;
    private String accountNumber;
    private int balance;

    //Constructors
    public BankAccount(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
    }

    public BankAccount(String accountHolderName, String accountNumber, int balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    //Getters
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    //Methods
    public int deposit(int amountToDeposit) {
        balance += amountToDeposit; //Takes current balance in account and adds the deposit amount and then returns the updated balance.
        return balance;
    }
    public int withdraw(int amountToWithdraw) {
        balance -= amountToWithdraw;
        return balance;
    }

}
