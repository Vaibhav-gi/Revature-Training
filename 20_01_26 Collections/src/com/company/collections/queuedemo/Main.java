package com.company.collections.queuedemo;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        //List Example
        List<String>names =new ArrayList<>();
        names.add("Sarika");
        names.add("Dinesh");
        names.add("23");
        names.add("Heena");
        List<Integer> evennumbers=new ArrayList<>();
        evennumbers.add(2);
        evennumbers.add(4);
        evennumbers.add(6);
        evennumbers.add(2);

        //iterating with for loop
        for(String n:names)
        {
            System.out.println(n);
        }
        //Iterator using
        Iterator<String> iterator=names.iterator();
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
        //streams (java 8)
        names.stream().filter(n->n.startsWith("D")).forEach(System.out::println);
//Set Example

        Set<Integer> numbers = new HashSet<>(evennumbers);
        System.out.println(numbers);
        numbers.add(22);
        numbers.add(12);
        numbers.add(14);
        numbers.add(14);

        System.out.println(numbers);
        Queue<String> queue=new LinkedList<>();
        queue.add("Tasl1");
        queue.add("Task2");
        queue.add("Task4");
        System.out.println(queue);
        //Map Example
        Map<String,Integer>score = new HashMap<>();
        score.put("Suresh",60);
        score.put("Jiya",23);


    }
}