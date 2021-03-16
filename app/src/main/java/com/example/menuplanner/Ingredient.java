package com.example.menuplanner;

public class Ingredient {
    public String id;
    public String name;
    public Boolean isCold;
    public String location;
    public float price;
    public String store;

    public Ingredient(String id, String name, Boolean isCold, String location, float price, String store)
    {
        this.id = id;
        this.name = name;
        this.isCold = isCold;
        this.location = location;
        this.price = price;
        this.store = store;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getCold() {
        return isCold;
    }

    public void setCold(Boolean cold) {
        isCold = cold;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }
}
