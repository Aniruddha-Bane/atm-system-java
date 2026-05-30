package service;

import model.User;

public class AuthenticationService {

    public boolean login(User user,
                         int enteredPin) {

        return user.getPin() == enteredPin;
    }
}