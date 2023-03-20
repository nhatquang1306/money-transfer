package com.techelevator;

public class CheckingAccount extends BankAccount {
    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }
    public int withdraw(int amountToWithdraw) {
        if (super.getBalance() < 0 && super.getBalance() > -100) {
            return super.withdraw(amountToWithdraw+10); //if we want to withdraw money and our account balance is less than 0 or more than -100 then you are charged an overdraft fee of 10
    } else {
            return getBalance(); //Otherwise return current balance
        }
} }
