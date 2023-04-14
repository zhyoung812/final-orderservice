package edu.c322final.orderservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public interface Side {
    @Id
    int id = 0;
    double price = 0;
    String name = "";
}
