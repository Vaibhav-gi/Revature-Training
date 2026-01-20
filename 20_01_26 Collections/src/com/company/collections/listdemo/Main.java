package com.company.collections.listdemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //List Example
        List<String>names =new ArrayList<>();
        names.add("Sarika");
        names.add("Dinesh");
        names.add("23");
        names.add("Heena");
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

    }
}