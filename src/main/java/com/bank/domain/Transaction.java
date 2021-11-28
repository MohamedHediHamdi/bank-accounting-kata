package com.bank.domain;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Transaction {


    private final String operationDate;
    private final int amount;

    public Transaction(String operationDate, int amount) {
        this.operationDate = operationDate;
        this.amount = amount;
    }
}
