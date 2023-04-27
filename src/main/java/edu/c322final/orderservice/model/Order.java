package edu.c322final.orderservice.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int customerId;
   private int turkeyCount;
   private int hamCount;
   private int avocadoCount;
    private double total;
    private String vegetables;
    private String cheese;
    private String bread;

    @OneToMany(cascade = CascadeType.ALL)
    private List<SideModel> sides;
    public int getTurkeyCount() {
        return turkeyCount;
    }

    public void setTurkeyCount(int turkeyCount) {
        this.turkeyCount = turkeyCount;
    }

    public List<SideModel> getSides() {
        return sides;
    }

    public void setSides(List<SideModel> sides) {
        this.sides = sides;
    }

    public int getHamCount() {
        return hamCount;
    }

    public String getCheese() {

        return cheese;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public void setHamCount(int hamCount) {
        this.hamCount = hamCount;
    }

    public int getAvocadoCount() {
        return avocadoCount;
    }

    public void setAvocadoCount(int avocadoCount) {
        this.avocadoCount = avocadoCount;
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


    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getVegetables() {
        return vegetables;
    }

    public void setVegetables(String vegetables) {
        this.vegetables = vegetables;
    }

}
