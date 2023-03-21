package com.techelevator;

public class CreditCardAccount implements Accountable{
    private String accountHolder;
    private String accountNumber;
    private int debt;

    public CreditCardAccount(String accountHolder, String accountNumber) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
    }

    @Override
    public int getBalance() {
        return 0-debt;
    }

    public int pay(int amountToPay) {
        //int newTotalOwed = this.debt;
        return debt -= amountToPay;
    }

    public int charge(int amountToCharge) {
        return debt += amountToCharge;
    }


    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getDebt() {
        return debt;
    }

}
