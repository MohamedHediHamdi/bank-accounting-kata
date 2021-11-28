package com.bank.domain;

import com.bank.Util.OperationDate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class TransactionTest {

	public static final String TODAY = "28/11/2021";

	private TransactionRepository transactionRepository;

	@Mock
	private OperationDate operationDate;

	@Before
	public void initialise(){
		transactionRepository = new TransactionRepository(operationDate);
	}

	@Test
	public void should_create_and_store_a_deposit_transaction() {
		given(operationDate.dateAsString()).willReturn(TODAY);
		transactionRepository.addDeposit(100);
		List<Transaction> transactions = transactionRepository.allTransactions();
		assertEquals(transactions.size(), 1);
		assertEquals(transactions.get(0), transaction(TODAY, 100));
	}

	@Test
	public void should_create_and_store_a_withdrawal_transaction() {
		given(operationDate.dateAsString()).willReturn(TODAY);
		transactionRepository.addWithDrawal(100);
		List<Transaction> transactions = transactionRepository.allTransactions();
		assertEquals(transactions.size(), 1);
		assertEquals(transactions.get(0), transaction(TODAY, -100));
	}

	private Transaction transaction(String operationDate, int amount){
		return new Transaction(operationDate, amount);
	}

}
