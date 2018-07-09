package edu.mum.sa.lab.customerapp.CustomerApp.model;

public class Account {

    private String accountNo;
    private String balance;

    public Account(String accountNo, String balance){
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public String getBalance() {
        return balance;
    }
}
