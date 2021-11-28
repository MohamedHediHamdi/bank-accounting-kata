package com.bank.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

	@Mock
	private TransactionRepository transactionRepository;

	private Account account;

	@Before
	public void initialise() {
		account = new Account(transactionRepository);
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

}