package service;

import model.User;
import util.FileHandler;

import java.util.List;

public class ATMService {

    private FileHandler fileHandler =
            new FileHandler();

    public void checkBalance(
            User user) {

        System.out.println(
                "\nCurrent Balance: ₹"
                        + user.getBalance());
    }

    public void deposit(
            User user,
            double amount) {

        if (amount <= 0) {

            System.out.println(
                    "Deposit amount must be positive.");

            return;
        }

        user.setBalance(
                user.getBalance()
                        + amount);

        fileHandler.updateBalance(
                user.getAccountNumber(),
                user.getBalance());

        fileHandler.saveTransaction(
                user.getAccountNumber()
                        + ",DEPOSIT,"
                        + amount);

        System.out.println(
                "Deposit successful.");

        System.out.println(
                "Updated Balance: ₹"
                        + user.getBalance());
    }

    public void withdraw(
            User user,
            double amount) {

        if (amount <= 0) {

            System.out.println(
                    "Withdrawal amount must be positive.");

            return;
        }

        if (amount > user.getBalance()) {

            System.out.println(
                    "Insufficient Balance.");

            return;
        }

        user.setBalance(
                user.getBalance()
                        - amount);

        fileHandler.updateBalance(
                user.getAccountNumber(),
                user.getBalance());

        fileHandler.saveTransaction(
                user.getAccountNumber()
                        + ",WITHDRAW,"
                        + amount);

        System.out.println(
                "Withdrawal successful.");

        System.out.println(
                "Remaining Balance: ₹"
                        + user.getBalance());
    }

    public void transactionHistory(
            User user) {

        List<String> transactions =
                fileHandler.loadTransactions();

        System.out.println(
                "\n===== TRANSACTION HISTORY =====");

        for (String transaction
                : transactions) {

            String[] data =
                    transaction.split(",");

            int accountNumber =
                    Integer.parseInt(
                            data[0]);

            if (accountNumber
                    == user.getAccountNumber()) {

                System.out.println(
                        data[1]
                                + " ₹"
                                + data[2]);
            }
        }
    }
}