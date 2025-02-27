package com.fwtcompany.statement;

import com.fwtcompany.account.BankAccount;
import java.time.format.DateTimeFormatter;

public class Statement {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private final BankAccount account;

    public Statement(BankAccount account) {
        this.account = account;
    }

    public String generate() {
        StringBuilder sb = new StringBuilder();
        String lineSeparator = System.lineSeparator();

        sb.append("=================================").append(lineSeparator)
                .append("Titular: ").append(account.getHolder()).append("\t")
                .append("Saldo: ").append(account.getBalance()).append(lineSeparator)
                .append("Extrato:").append(lineSeparator);

        account.getTransactionHistory().forEach(transaction ->
                sb.append(String.format("*\tValor: %.2f | Tipo: %s | Data: %s%s",
                        transaction.getAmount(),
                        transaction.getType(),
                        transaction.getDate().format(FORMATTER),
                        lineSeparator))
        );

        sb.append("=================================");

        return sb.toString();
    }
}
