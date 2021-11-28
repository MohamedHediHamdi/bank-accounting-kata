package com.bank.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
public class Transaction {


    private final String operationDate;
    private final int amount;

    public Transaction(String operationDate, int amount) {
        this.operationDate = operationDate;
        this.amount = amount;
    }
}
