package com.bank.domain;

import com.bank.Util.OperationDate;
import com.sun.deploy.net.MessageHeader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransactionRepository {

    private final OperationDate operationDate;
    private List<Transaction> transactions = new ArrayList<>();

    public TransactionRepository(OperationDate operationDate) {
        this.operationDate = operationDate;
    }

    public void addDeposit(int amount){
        Transaction depositTransaction = new Transaction(operationDate.dateAsString(), amount);
        transactions.add(depositTransaction);
    }

    public void addWithDrawal(int amount){
        Transaction withDrawalTransaction = new Transaction(operationDate.dateAsString(), -amount);
        transactions.add(withDrawalTransaction);
    }

    public List<Transaction> allTransactions() {
        return Collections.unmodifiableList(transactions);
    }
}
