package com.company.banking;

import com.company.banking.model.BankAccount;

public class Main {
    public static void main(String[] args) {

        BankAccount acc = new BankAccount("101", 5000);
        acc.deposit(1000);
        acc.withdraw(2000);

        System.out.println("Balance: " + acc.getBalance());
        acc.displayBankRules();
    }
}
