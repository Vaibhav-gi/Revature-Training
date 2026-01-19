package com.company.employee.model;

public class Employee {

    protected int employeeId;
    protected String name;
    private double salary;

    public static final String COMPANY_POLICY = "Work from Office";

    public Employee(int employeeId, String name, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
    }

    public final double calculateBonus() {
        return salary * 0.10;
    }
}
