package com.techelevator.tenmo.models;

public class Transfer {

    private long toUser;
    private long fromUser;
    private Double amount;

    public long getToUser() {
        return toUser;
    }

    public void setToUser(long toUser) {
        this.toUser = toUser;
    }

    public long getFromUser() {
        return fromUser;
    }

    public void setFromUser(long fromUser) {
        this.fromUser = fromUser;
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
                "toUser=" + toUser +
                ", fromUser=" + fromUser +
                ", amount=" + amount +
                '}';
    }
}
