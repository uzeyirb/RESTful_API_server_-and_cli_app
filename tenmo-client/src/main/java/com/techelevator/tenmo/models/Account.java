package com.techelevator.tenmo.models;

import java.math.BigDecimal;

public class Account {

    private long accountId;
    private long userId;
    private Double balance;

    public Account() {
    }

    public Account(long accountId, long userId, Double balance) {
        this.accountId = accountId;
        this.userId = userId;
        this.balance = balance;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
