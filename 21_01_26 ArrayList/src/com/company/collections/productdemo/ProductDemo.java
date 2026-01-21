package com.company.collections.productdemo;

import java.util.*;

public class ProductDemo {
    public static void main(String[] args) {

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(new Product(101, "Soap", 76.80));
        productList.add(new Product(102, "Toys", 256.80));

        System.out.println(productList);

        HashMap<Integer, Product> productMap = new HashMap<>();
        productMap.put(1, new Product(1101, "TV", 56000));

        for (Map.Entry<Integer, Product> e : productMap.entrySet()) {
            System.out.println(e.getKey() + " = " + e.getValue().prName.toUpperCase());
        }
    }
}

