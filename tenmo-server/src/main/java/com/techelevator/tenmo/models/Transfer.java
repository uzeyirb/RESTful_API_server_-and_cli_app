package com.techelevator.tenmo.models;

public class Transfer {
    private long transferId;
    private long transferTypeId;
    private long transferStatusTypeId;
    private long toAccount;
    private long fromAccount;
    private Double amount;

    public Transfer(long toAccount, long fromAccount, Double amount) {
        this.toAccount = toAccount;
        this.fromAccount = fromAccount;
        this.amount = amount;
    }

    public Transfer() {
    }

    public Transfer(long transferTypeId, long transferStatusTypeId, long toAccount, long fromAccount, Double amount) {
        this.transferTypeId = transferTypeId;
        this.transferStatusTypeId = transferStatusTypeId;
        this.toAccount = toAccount;
        this.fromAccount = fromAccount;
        this.amount = amount;
    }

    public Transfer(long transferId, long transferTypeId, long transferStatusTypeId, long toAccount, long fromAccount, Double amount) {
        this.transferId = transferId;
        this.transferTypeId = transferTypeId;
        this.transferStatusTypeId = transferStatusTypeId;
        this.toAccount = toAccount;
        this.fromAccount = fromAccount;
        this.amount = amount;
    }

    public long getTransferId() {
        return transferId;
    }

    public void setTransferId(long transferId) {
        this.transferId = transferId;
    }

    public long getTransferTypeId() {
        return transferTypeId;
    }

    public void setTransferTypeId(long transferTypeId) {
        this.transferTypeId = transferTypeId;
    }

    public long getTransferStatusTypeId() {
        return transferStatusTypeId;
    }

    public void setTransferStatusTypeId(long transferStatusTypeId) {
        this.transferStatusTypeId = transferStatusTypeId;
    }

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
}
