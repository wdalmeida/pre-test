package com.priceminister.account.implementation;

import com.priceminister.account.*;


public class CustomerAccount implements Account {

    private Double balance;

    public CustomerAccount() {
        this.balance=0.0;
    }

    public void add(Double addedAmount) {
        // TODO Auto-generated method stub
    }

    public Double getBalance() {
        return this.balance;
    }

    public Double withdrawAndReportBalance(Double withdrawnAmount, AccountRule rule) 
    		throws IllegalBalanceException {
        // TODO Auto-generated method stub
        return null;
    }

}
