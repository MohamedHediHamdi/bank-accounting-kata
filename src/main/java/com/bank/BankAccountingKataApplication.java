package com.bank;

import com.bank.Util.ConsolePrinter;
import com.bank.Util.OperationDate;
import com.bank.domain.Account;
import com.bank.domain.StatementPrinter;
import com.bank.domain.TransactionRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankAccountingKataApplication {

	public static void main(String[] args) {
		//SpringApplication.run(BankAccountingKataApplication.class, args);
		OperationDate operationDate = new OperationDate();
		TransactionRepository transactionRepository = new TransactionRepository(operationDate);
		ConsolePrinter consolePrinter = new ConsolePrinter();
		StatementPrinter statementPrinter = new StatementPrinter(consolePrinter);
		Account account = new Account(transactionRepository, statementPrinter);
		account.deposit(1000);
		account.withdrawal(300);
		account.deposit(2000);

		account.printStatement();
	}

}
