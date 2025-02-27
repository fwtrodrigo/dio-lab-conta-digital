package com.fwtcompany.application;

import com.fwtcompany.customer.AccountHolder;
import com.fwtcompany.account.BankAccount;
import com.fwtcompany.account.CheckingAccount;
import com.fwtcompany.account.SavingsAccount;
import com.fwtcompany.statement.Statement;

import java.util.Scanner;

public class App {
    private final static Scanner scanner = new Scanner(System.in);
    private BankAccount bankAccount;

    public void showMenu() {
        createAccount();
        divisorH1();

        System.out.println("Bem vindo ao aplicativo, " + bankAccount.getHolder());

        while (true) {
            System.out.println("Saldo atual: R$" + String.format("%.2f", bankAccount.getBalance()));

            divisorH2();

            System.out.println("1 - Creditar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Extrato");
            System.out.println("4 - Sair");
            System.out.println("Digite a opção desejada: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> credit();
                case 2 -> debit();
                case 3 -> {
                    history();
                    waitForKeyPress();
                }
                case 4 -> System.exit(0);
                default -> System.out.println("Opção " + opcao + " invalida");
            }

            divisorH1();
        }
    }

    public void createAccount() {
        System.out.println("Informe o seu name: ");
        String name = scanner.nextLine();

        System.out.println("Informe o seu CPF: ");
        String cpf = scanner.nextLine();

        AccountHolder holder = new AccountHolder(name, cpf);

        System.out.println("Digite o tipo de conta desejada:\n1) Conta Corrente\n2) Conta Poupança");
        int userChoice = scanner.nextInt();

        switch (userChoice) {
            case 1:
                bankAccount = new CheckingAccount(1, holder);
                break;
            case 2:
                bankAccount = new SavingsAccount(1, holder);
                break;
            default:
                throw new IllegalArgumentException("Opção invalida : " + userChoice);
        }

        divisorH1();
    }

    private void credit() {
        System.out.println("Informe o valor: ");
        try {
            double valor = scanner.nextDouble();
            bankAccount.credit(valor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void debit() {
        System.out.println("Informe o valor: ");
        try {
            double valor = scanner.nextDouble();
            bankAccount.debit(valor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void history() {
        Statement statement = new Statement(bankAccount);
        System.out.println(statement.generate());
    }

    private void divisorH1() {
        System.out.println("===============================");
    }

    private void divisorH2() {
        System.out.println("-------------------------------");
    }

    private void waitForKeyPress() {
        System.out.println("Tecle enter para continuar");
        scanner.nextLine();
        scanner.nextLine();
    }
}
