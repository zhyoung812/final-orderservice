package edu.c322final.orderservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ConcreteSandwich implements Sandwich {
    @Id
    private int id;
    double price;
    String bread;
    String cheese;
    String veggies;
    public double getPrice() {
        return price;
    }
}
