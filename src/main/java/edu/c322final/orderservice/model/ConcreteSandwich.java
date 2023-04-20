package edu.c322final.orderservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

public class ConcreteSandwich implements Sandwich {
    private int id;
    double price =1.0;
    String bread;
    String cheese;
    String veggies;
    public double getPrice() {
        return price;
    }
}
