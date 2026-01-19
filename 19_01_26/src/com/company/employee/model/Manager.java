package com.company.employee.model;

public class Manager extends Employee {

    public Manager(int id, String name, double salary) {
        super(id, name, salary);
    }

    public void showDetails() {
        System.out.println(employeeId);
        System.out.println(name);
    }

    // ❌ cannot override calculateBonus()
}
