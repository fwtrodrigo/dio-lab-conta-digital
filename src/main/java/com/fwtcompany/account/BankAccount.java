package com.fwtcompany.account;

import com.fwtcompany.customer.AccountHolder;
import com.fwtcompany.statement.TransactionType;
import com.fwtcompany.statement.Transaction;

import java.util.ArrayList;
import java.util.List;

public abstract class BankAccount {
    private final int number;
    private final AccountHolder holder;
    private final List<Transaction> transactionHistory;
    protected double balance;

    public BankAccount(int number, AccountHolder holder) {
        this.number = number;
        this.holder = holder;
        this.balance = 0;
        this.transactionHistory = new ArrayList<>();
    }

    public int getNumber() {
        return number;
    }

    public String getHolder() {
        return holder.name();
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public final void credit(double amount) {
        makeCredit(amount);
        this.transactionHistory.add(new Transaction(amount, TransactionType.CREDIT));
    }

    public final void debit(double valor) {
        makeDebit(valor);
        this.transactionHistory.add(new Transaction(valor, TransactionType.DEBIT));
    }

    protected abstract void makeCredit(double amount);

    protected abstract void makeDebit(double amount);

}
