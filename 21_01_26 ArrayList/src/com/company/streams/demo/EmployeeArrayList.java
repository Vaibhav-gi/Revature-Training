package com.company.streams.demo;

import com.company.streams.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeArrayList {

    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(1, "Shashi", "sales", 35000));
        employeeList.add(new Employee(2, "Suresh", "account", 45000.56));
        employeeList.add(new Employee(3, "Neeta", "sales", 37000.33));
        employeeList.add(new Employee(4, "Lakshmi", "IT", 38000.38));

        // 1️⃣ Filter by department (sales)
        List<Employee> salesDept = employeeList.stream()
                .filter(emp -> emp.getDepartment().equalsIgnoreCase("sales"))
                .collect(Collectors.toList());

        System.out.println("Sales department data");
        salesDept.forEach(System.out::println);

        // 2️⃣ Employees earning more than 30000
        List<String> highEarners = employeeList.stream()
                .filter(e -> e.getSalary() > 30000)
                .map(Employee::getName)
                .collect(Collectors.toList());

        System.out.println("More than 30 thousand names");
        System.out.println(highEarners);
    }
}
