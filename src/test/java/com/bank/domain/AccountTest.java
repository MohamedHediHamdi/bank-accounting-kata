package com.bank.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

	@Mock
	private TransactionRepository transactionRepository;

	@Mock
	private StatementPrinter statementPrinter;

	private Account account;

	@Before
	public void initialise() {
		account = new Account(transactionRepository, statementPrinter);
	}
	
	@Test
	public void should_store_a_deposit_transaction() {
		account.deposit(100);
		verify(transactionRepository).addDeposit(100);
	}

	@Test
	public void should_store_a_withdrawal_transaction() {
		account.withdrawal(100);
		verify(transactionRepository).addWithDrawal(100);
	}

	@Test
	public void should_print_statement() {
		List<Transaction> transactions = asList(new Transaction());
		given(transactionRepository.allTransactions()).willReturn(transactions);
		account.printStatement();
		verify(statementPrinter).print(transactions);
	}

}
