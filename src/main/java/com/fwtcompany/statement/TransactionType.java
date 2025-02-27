package com.fwtcompany.statement;

public enum TransactionType {
    CREDIT("CREDITO"),
    DEBIT("DEBITO");

    private final String description;

    TransactionType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
