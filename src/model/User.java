package model;

public class User {

    private String username;
    private int pin;

    public User(String username, int pin) {
        this.username = username;
        this.pin = pin;
    }

    public String getUsername() {
        return username;
    }

    public int getPin() {
        return pin;
    }
}