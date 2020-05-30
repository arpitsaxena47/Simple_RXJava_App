package com.arpit.rxjavaapp;

import java.math.BigDecimal;
import java.util.Date;

public class Entries {
    private final String entryName;
    private final BigDecimal entryprice;
    private final Date entryDate;

    public Entries(String entryName, BigDecimal entryprice, Date entryDate) {
        this.entryName = entryName;
        this.entryprice = entryprice;
        this.entryDate = entryDate;
    }

    public String getEntryName() {
        return entryName;
    }

    public BigDecimal getEntryprice() {
        return entryprice;
    }

    public Date getEntryDate() {
        return entryDate;
    }
}
