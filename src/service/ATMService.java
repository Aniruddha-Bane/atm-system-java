package service;

import model.BankAccount;

public class ATMService {

    public void checkBalance(BankAccount account) {

        System.out.println("\nCurrent Balance: ₹" + account.getBalance());
    }
}