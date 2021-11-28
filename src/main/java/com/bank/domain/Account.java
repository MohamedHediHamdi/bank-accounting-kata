package com.bank.domain;

public class Account {

    private TransactionRepository transactionRepository;

    public Account(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    public void deposit(int amount) {
        transactionRepository.addDeposit(amount);
    }

    public void withdrawal(int amount) {
        transactionRepository.addWithDrawal(amount);
    }

    public void printStatement() {

    }
}
