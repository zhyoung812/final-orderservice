package edu.c322final.orderservice.model;

public class HamDecorator implements SandwichDecorator {
    Sandwich sandwich;

    public double getPrice() {
        return 0.7 + sandwich.getPrice();
    }
}
