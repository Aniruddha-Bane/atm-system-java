package service;

import model.User;
import util.FileHandler;

import java.util.List;

public class AuthenticationService {

    private FileHandler fileHandler =
            new FileHandler();

    public User login(
            int accountNumber,
            int pin) {

        List<User> users =
                fileHandler.loadUsers();

        for (User user : users) {

            if (user.getAccountNumber()
                    == accountNumber
                    && user.getPin() == pin) {

                return user;
            }
        }

        return null;
    }
}