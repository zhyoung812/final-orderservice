package edu.c322final.orderservice.model;

public class Chips implements Side {
    double price = 8.0;
    String name;
    public Chips(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
}
