package com.fwtcompany.statement;

import java.time.LocalDateTime;

public class Transaction {
    private final double amount;
    private final TransactionType type;
    private final LocalDateTime date;

    public Transaction(double amount, TransactionType type) {
        this.amount = amount;
        this.type = type;
        this.date = LocalDateTime.now();
    }

    public double getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
