package com.company.employee;

import com.company.employee.model.Manager;

public class Main {
    public static void main(String[] args) {

        Manager m = new Manager(1, "Rahul", 80000);
        m.showDetails();

        System.out.println("Bonus: " + m.calculateBonus());
        System.out.println("Policy: " + Manager.COMPANY_POLICY);
    }
}
