package com.bank.domain;

import com.bank.Util.ConsolePrinter;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StatementPrinter {

    private final String STATEMENT_HEADER = "DATE       | AMOUNT   | BALANCE";

    private final ConsolePrinter consolePrinter;
    private final DecimalFormat decimalFormatter = new DecimalFormat("#.00");

    public StatementPrinter(ConsolePrinter consolePrinter) {
        this.consolePrinter = consolePrinter;
    }

    public void print(List<Transaction> transactions) {
        consolePrinter.printLine(STATEMENT_HEADER);
        printStatementLines(transactions);
    }

    private void printStatementLines(List<Transaction> transactions) {
        AtomicInteger currentBalance = new AtomicInteger(0);
        transactions.stream()
                .map(transaction -> statementLine(transaction, currentBalance))
                .collect(Collectors.toCollection(LinkedList::new))
                .descendingIterator()
                .forEachRemaining(consolePrinter::printLine);
    }

    private String statementLine(Transaction transaction, AtomicInteger currentBalance) {
        return transaction.getOperationDate()
                + " | "
                + decimalFormatter.format(transaction.getAmount())
                + " | "
                + decimalFormatter.format(currentBalance.addAndGet(transaction.getAmount()));
    }
}
