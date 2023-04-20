package edu.c322final.orderservice.model;

public class TurkeyDecorator implements SandwichDecorator {
    Sandwich sandwich;
    public TurkeyDecorator(Sandwich sandwich) {
        this.sandwich = sandwich;
    }
    public double getPrice() {
        return 0.8 + sandwich.getPrice();
    }
}
