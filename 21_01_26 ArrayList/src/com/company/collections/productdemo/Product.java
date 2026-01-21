package com.company.collections.productdemo;

public class Product {
    int prodId;
    String prName;
    double price;

    public Product(int prodId, String prName, double price) {
        this.prodId = prodId;
        this.prName = prName;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "prodId=" + prodId +
                ", prName='" + prName + '\'' +
                ", price=" + price +
                '}';
    }
}
