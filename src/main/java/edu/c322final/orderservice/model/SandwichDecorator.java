package edu.c322final.orderservice.model;

public interface SandwichDecorator  extends Sandwich{
    Sandwich sandwich = null;
    public double getPrice();
}
