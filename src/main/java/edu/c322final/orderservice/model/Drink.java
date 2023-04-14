package edu.c322final.orderservice.model;

public class Drink implements Side {
    double basePrice = 1.0;
    String name;
    int size;
    public Drink(String name,int size) {
        this.name = name;
        this.size = size;
    }

    public double getPrice() {
        return basePrice + 0.5*size;
    }
}
