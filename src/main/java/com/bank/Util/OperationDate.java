package com.bank.Util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OperationDate {

    private final String DD_MM_YYYY = "dd/MM/yyyy";

    public String dateAsString(){
        return getLocalDate().format(DateTimeFormatter.ofPattern(DD_MM_YYYY));
    }

    protected LocalDate getLocalDate() {
        return LocalDate.now();
    }
}
