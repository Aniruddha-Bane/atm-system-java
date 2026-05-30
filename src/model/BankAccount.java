package model;

public class BankAccount {

    private String accountHolder;
    private int accountNumber;
    private double balance;
    private String accountType;

    public BankAccount(String accountHolder,
                       int accountNumber,
                       double balance,
                       String accountType) {

        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}