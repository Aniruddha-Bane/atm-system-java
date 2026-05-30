package main;

import java.util.Scanner;

import model.BankAccount;
import model.User;
import service.ATMService;
import service.AuthenticationService;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        User user =
                new User(
                        "Aniruddha",
                        1234
                );

        BankAccount account =
                new BankAccount(
                        "Aniruddha",
                        1001,
                        5000,
                        "Savings"
                );

        AuthenticationService auth =
                new AuthenticationService();

        ATMService atmService =
                new ATMService();

        System.out.println(
                "===== ATM LOGIN =====");

        System.out.print(
                "Enter PIN: ");

        int enteredPin =
                scanner.nextInt();

        if (!auth.login(
                user,
                enteredPin)) {

            System.out.println(
                    "Invalid PIN.");

            scanner.close();

            return;
        }

        System.out.println(
                "\nLogin Successful!");

        boolean loggedIn = true;

        while (loggedIn) {

            showMenu();

            int choice =
                    scanner.nextInt();

            switch (choice) {

                case 1:

                    atmService.checkBalance(
                            account);

                    break;

                case 2:

                    System.out.print(
                            "Enter Deposit Amount: ");

                    double depositAmount =
                            scanner.nextDouble();

                    atmService.deposit(
                            account,
                            depositAmount);

                    break;

                case 3:

                    System.out.print(
                            "Enter Withdrawal Amount: ");

                    double withdrawAmount =
                            scanner.nextDouble();

                    atmService.withdraw(
                            account,
                            withdrawAmount);

                    break;

                case 4:

                    atmService.miniStatement(
                            account);

                    break;

                case 5:

                    loggedIn = false;

                    System.out.println(
                            "Logged out successfully.");

                    break;

                default:

                    System.out.println(
                            "Invalid option.");
            }
        }

        scanner.close();
    }

    public static void showMenu() {

        System.out.println(
                "\n===== ATM MENU =====");

        System.out.println(
                "1. Check Balance");

        System.out.println(
                "2. Deposit");

        System.out.println(
                "3. Withdraw");

        System.out.println(
                "4. Mini Statement");

        System.out.println(
                "5. Logout");

        System.out.print(
                "Choose option: ");
    }
}