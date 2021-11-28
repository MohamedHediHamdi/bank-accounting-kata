package com.bank.domain;

import com.bank.Util.ConsolePrinter;
import com.bank.Util.OperationDate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class PrintStatementTest {

    @Mock
    ConsolePrinter console;

    @Mock
    OperationDate operationDate;

    private Account account;

    @Before
    public void initialise(){
        TransactionRepository transactionRepository = new TransactionRepository(operationDate);
        StatementPrinter statementPrinter = new StatementPrinter(console);
        account = new Account(transactionRepository, statementPrinter);
    }

    @Test
    public void print_statement_containing_all_transactions() {
        given(operationDate.dateAsString()).willReturn("22/11/2021", "25/11/2021", "28/11/2021");

      account.deposit(100);
      account.withdrawal(100);
      account.deposit(100);

      account.printStatement();

        InOrder inOrder = Mockito.inOrder(console);

        inOrder.verify(console).printLine("DATE       | AMOUNT   | BALANCE");
        inOrder.verify(console).printLine("28/11/2021 |  2000.00 | 2700.00");
        inOrder.verify(console).printLine("25/11/2021 |  -300.00 | 700.00");
        inOrder.verify(console).printLine("22/11/2021 |  1000.00 | 1000.00");
    }
}
