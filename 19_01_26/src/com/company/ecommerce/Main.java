package com.company.ecommerce;

import com.company.ecommerce.model.Product;

public class Main {
    public static void main(String[] args) {

        double gst = Product.calculateGST(1000);
        System.out.println("GST: " + gst);
    }
}
