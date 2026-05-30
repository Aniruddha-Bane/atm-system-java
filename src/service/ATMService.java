package service;

import model.BankAccount;

public class ATMService {

    public void checkBalance(
            BankAccount account) {

        System.out.println(
                "\nCurrent Balance: ₹"
                        + account.getBalance());
    }

    public void deposit(
            BankAccount account,
            double amount) {

        if (amount <= 0) {

            System.out.println(
                    "Deposit amount must be positive.");

            return;
        }

        account.setBalance(
                account.getBalance() + amount);

        account.setTransactionHistory(
                account.getTransactionHistory()
                        + "\nDeposit: ₹"
                        + amount);

        System.out.println(
                "Deposit successful.");

        System.out.println(
                "Updated Balance: ₹"
                        + account.getBalance());
    }

    public void withdraw(
            BankAccount account,
            double amount) {

        if (amount <= 0) {

            System.out.println(
                    "Withdrawal amount must be positive.");

            return;
        }

        if (amount > account.getBalance()) {

            System.out.println(
                    "Insufficient Balance.");

            return;
        }

        account.setBalance(
                account.getBalance() - amount);

        account.setTransactionHistory(
                account.getTransactionHistory()
                        + "\nWithdraw: ₹"
                        + amount);

        System.out.println(
                "Withdrawal successful.");

        System.out.println(
                "Remaining Balance: ₹"
                        + account.getBalance());
    }

    public void miniStatement(
            BankAccount account) {

        System.out.println(
                "\n===== MINI STATEMENT =====");

        if (account.getTransactionHistory().isEmpty()) {

            System.out.println(
                    "No transactions available.");
        }
        else {

            System.out.println(
                    account.getTransactionHistory());
        }

        System.out.println(
                "\nCurrent Balance: ₹"
                        + account.getBalance());
    }
}