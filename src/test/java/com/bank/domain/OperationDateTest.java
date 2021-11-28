package com.bank.domain;

import com.bank.Util.OperationDate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;

@RunWith(MockitoJUnitRunner.class)
public class OperationDateTest {
	
	@Test
	public void should_return_date_in_dd_MM_yyyy_format() {
		OperationDate operationDate = new InnerOperationDateTest();
		String date = operationDate.dateAsString();
		Assert.assertEquals(date, "28/11/2021");
	}

	private class InnerOperationDateTest extends OperationDate {
		@Override
		protected LocalDate getLocalDate() {
			return LocalDate.of(2021, 11, 25);
		}
	}

}
