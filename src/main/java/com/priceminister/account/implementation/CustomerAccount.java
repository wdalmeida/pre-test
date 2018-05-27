package com.priceminister.account.implementation;

import com.priceminister.account.*;

import java.util.logging.Level;
import java.util.logging.Logger;


public class CustomerAccount implements Account {

    private final Logger logger = Logger.getLogger(CustomerAccount.class.getName());

    private Double balance;

    public CustomerAccount() {
        this.balance=0.0;
    }

    public void add(Double addedAmount) {
        logger.log(Level.INFO,"add {0} to the balance",addedAmount);
        this.balance += addedAmount;
    }

    public Double getBalance() {
        logger.log(Level.INFO,()->"the balance is "+ this.balance);
        return this.balance;
    }

    public Double withdrawAndReportBalance(Double withdrawnAmount, AccountRule rule)
            throws IllegalBalanceException {
        // TODO Auto-generated method stub
        return null;
    }

}
