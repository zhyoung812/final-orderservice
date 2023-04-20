package edu.c322final.orderservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


public interface Side {

    int id = 0;
    double price = 0;
    String name = "";


    public default double getPrice() {
        return price;
    }
}
