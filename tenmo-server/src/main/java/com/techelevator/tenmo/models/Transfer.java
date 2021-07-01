package com.techelevator.tenmo.models;

public class Transfer {

    private long toAccount;
    private long fromAccount;
    private Double amount;

    public long getToAccount() {
        return toAccount;
    }

    public void setToAccount(long toAccount) {
        this.toAccount = toAccount;
    }

    public long getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(long fromAccount) {
        this.fromAccount = fromAccount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "toAccount=" + toAccount +
                ", fromAccount=" + fromAccount +
                ", amount=" + amount +
                '}';
    }
}
