package com.example.menuplanner;

public class Ingredient {
    public String id;
    public String name;
    public Boolean isCold;
    public String location;
    public float price;
    public String store;

    public Ingredient(String id, String name, Boolean isCold, String location, float price, String store) {
        this.id = id;
        this.name = name;
        this.isCold = isCold;
        this.location = location;
        this.price = price;
        this.store = store;
    }
}
