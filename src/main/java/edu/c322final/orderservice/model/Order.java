package edu.c322final.orderservice.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int customerId;
    @OneToOne(cascade = CascadeType.ALL)
    private ConcreteSandwich sandwich;
    private double total;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Side> sides;
    public SideIterator getIterator() {
        return new SideIterator(sides);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public ConcreteSandwich getSandwich() {
        return sandwich;
    }

    public void setSandwich(ConcreteSandwich sandwich) {
        this.sandwich = sandwich;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<Side> getSides() {
        return sides;
    }

    public void setSides(List<Side> sides) {
        this.sides = sides;
    }
}
