package main;

import model.User;
import service.ATMService;
import service.AuthenticationService;

import java.util.Scanner;

public class Main {

    public static void main(
            String[] args) {

        Scanner scanner =
                new Scanner(System.in);

        AuthenticationService auth =
                new AuthenticationService();

        ATMService atm =
                new ATMService();

        System.out.print(
                "Account Number: ");

        int accountNumber =
                scanner.nextInt();

        System.out.print(
                "PIN: ");

        int pin =
                scanner.nextInt();

        User currentUser =
                auth.login(
                        accountNumber,
                        pin);

        if (currentUser == null) {

            System.out.println(
                    "Invalid credentials.");

            return;
        }

        boolean loggedIn = true;

        while (loggedIn) {

            System.out.println(
                    "\n1. Check Balance");
            System.out.println(
                    "2. Deposit");
            System.out.println(
                    "3. Withdraw");
            System.out.println(
                    "4. Transaction History");
            System.out.println(
                    "5. Logout");

            int choice =
                    scanner.nextInt();

            switch (choice) {

                case 1:
                    atm.checkBalance(
                            currentUser);
                    break;

                case 2:

                    System.out.print(
                            "Amount: ");

                    atm.deposit(
                            currentUser,
                            scanner.nextDouble());

                    break;

                case 3:

                    System.out.print(
                            "Amount: ");

                    atm.withdraw(
                            currentUser,
                            scanner.nextDouble());

                    break;

                case 4:

                    atm.transactionHistory(
                            currentUser);

                    break;

                case 5:

                    loggedIn = false;

                    System.out.println(
                            "Logged out.");

                    break;

                default:

                    System.out.println(
                            "Invalid choice.");
            }
        }

        scanner.close();
    }
}