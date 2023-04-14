package edu.c322final.orderservice.model;

public class AvocadoDecorator implements SandwichDecorator {
    Sandwich sandwich;

    public double getPrice() {
        return 0.75 + sandwich.getPrice();
    }
}
