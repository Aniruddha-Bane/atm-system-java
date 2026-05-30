package util;

import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private static final String USERS_FILE =
            "data/users.txt";

    private static final String TRANSACTION_FILE =
            "data/transactions.txt";

    public List<User> loadUsers() {

        List<User> users =
                new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(
                                     USERS_FILE))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data =
                        line.split(",");

                users.add(
                        new User(
                                Integer.parseInt(data[0]),
                                data[1],
                                Integer.parseInt(data[2]),
                                Double.parseDouble(data[3])
                        )
                );
            }

        } catch (IOException e) {

            System.out.println(
                    "Error loading users."
            );
        }

        return users;
    }

    public void updateBalance(
            int accountNumber,
            double newBalance) {

        List<User> users =
                loadUsers();

        try (PrintWriter writer =
                     new PrintWriter(
                             new FileWriter(
                                     USERS_FILE))) {

            for (User user : users) {

                if (user.getAccountNumber()
                        == accountNumber) {

                    user.setBalance(
                            newBalance);
                }

                writer.println(
                        user.getAccountNumber()
                                + ","
                                + user.getName()
                                + ","
                                + user.getPin()
                                + ","
                                + user.getBalance()
                );
            }

        } catch (IOException e) {

            System.out.println(
                    "Error updating balance."
            );
        }
    }

    public void saveTransaction(
            String transaction) {

        try (FileWriter writer =
                     new FileWriter(
                             TRANSACTION_FILE,
                             true)) {

            writer.write(
                    transaction + "\n");

        } catch (IOException e) {

            System.out.println(
                    "Error saving transaction."
            );
        }
    }

    public List<String> loadTransactions() {

        List<String> transactions =
                new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(
                                     TRANSACTION_FILE))) {

            String line;

            while ((line = reader.readLine()) != null) {

                transactions.add(line);
            }

        } catch (IOException e) {

            System.out.println(
                    "No transaction history found."
            );
        }

        return transactions;
    }
}