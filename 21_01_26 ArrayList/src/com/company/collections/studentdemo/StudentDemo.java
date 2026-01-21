package com.company.collections.studentdemo;

import java.util.*;

public class StudentDemo {
    public static void main(String[] args) {

        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "Rahul", 78.5));
        studentList.add(new Student(2, "Anita", 88.0));

        System.out.println(studentList);

        HashMap<Integer, Student> studentMap = new HashMap<>();
        studentMap.put(101, new Student(11, "Amit", 82.3));

        for (Map.Entry<Integer, Student> e : studentMap.entrySet()) {
            System.out.println(e.getKey() + " = " + e.getValue().studentName.toUpperCase());
        }
    }
}
