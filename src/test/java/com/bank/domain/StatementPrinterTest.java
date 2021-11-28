package com.bank.domain;

import com.bank.Util.ConsolePrinter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StatementPrinterTest {

	private static final List<Transaction> NO_TRANSACTIONS = Collections.emptyList();
	StatementPrinter statementPrinter;

	@Mock
	private ConsolePrinter consolePrinter;

	@Before
	public void initialise(){
		statementPrinter =  new StatementPrinter(consolePrinter);
	}


	@Test
	public void should_print_the_header() {
		statementPrinter.print(NO_TRANSACTIONS);
		verify(consolePrinter).printLine("DATE       | AMOUNT   | BALANCE");
	}

	@Test
	public void should_print_transactions() {
		List<Transaction> transactions = makingTransactions(deposit("22/11/2021", 1000),
															withDrawal("25/11/2021", 300),
															deposit("28/11/2021", 2000));
		statementPrinter.print(transactions);

		InOrder inOrder = Mockito.inOrder(consolePrinter);

		inOrder.verify(consolePrinter).printLine("DATE       | AMOUNT   | BALANCE");
		inOrder.verify(consolePrinter).printLine("28/11/2021 | 2000.00 | 2700.00");
		inOrder.verify(consolePrinter).printLine("25/11/2021 | -300.00 | 700.00");
		inOrder.verify(consolePrinter).printLine("22/11/2021 | 1000.00 | 1000.00");
	}

	private Transaction deposit(String date, int amount){
		return new Transaction(date, amount);
	}

	private Transaction withDrawal(String date, int amount){
		return new Transaction(date, -amount);
	}

	private List<Transaction> makingTransactions(Transaction... transactions){
		return asList(transactions);
	}

}
