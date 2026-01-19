package com.company.ecommerce.model;

public final class Product {

    int productId;
    String productName;
    private double price;

    public static final double GST_RATE = 18;

    public Product(int productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public static double calculateGST(double price) {
        return price * GST_RATE / 100;
    }
}
