package com.fwtcompany.account;

import com.fwtcompany.customer.AccountHolder;

public class CheckingAccount extends BankAccount {

    public CheckingAccount(int number, AccountHolder accountHolder) {
        super(number, accountHolder);
    }

    @Override
    protected void makeCredit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Valor deve ser positivo.");
        }

        balance += amount;
    }

    @Override
    protected void makeDebit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Valor deve ser positivo.");
        }

        if (balance < amount) {
            throw new RuntimeException("Saldo insuficiente.");
        }

        balance -= amount;
    }
}
