package main;

import java.util.Scanner;

import model.User;
import model.BankAccount;
import service.AuthenticationService;
import service.ATMService;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        User user =
                new User("Aniruddha", 1234);

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

        System.out.println("===== ATM LOGIN =====");

        System.out.print("Enter PIN: ");

        int enteredPin = scanner.nextInt();

        if (!auth.login(user, enteredPin)) {

            System.out.println("Invalid PIN.");

            scanner.close();

            return;
        }

        System.out.println(
                "\nLogin Successful!"
        );

        boolean loggedIn = true;

        while (loggedIn) {

            showMenu();

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    atmService.checkBalance(
                            account
                    );

                    break;

                case 2:

                    loggedIn = false;

                    System.out.println(
                            "Logged out successfully."
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid option."
                    );
            }
        }

        scanner.close();
    }

    public static void showMenu() {

        System.out.println(
                "\n===== ATM MENU ====="
        );

        System.out.println(
                "1. Check Balance"
        );

        System.out.println(
                "2. Logout"
        );

        System.out.print(
                "Choose option: "
        );
    }
}