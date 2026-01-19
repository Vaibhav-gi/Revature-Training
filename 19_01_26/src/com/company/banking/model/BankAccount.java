package com.company.banking.model;

public class BankAccount {

    private String accountNumber;
    private double balance;

    public static final String BANK_NAME = "Vikas Bank";

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit");
            return;
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            System.out.println("Invalid withdrawal");
            return;
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public final void displayBankRules() {
        System.out.println("Minimum balance must be maintained");
    }
}
