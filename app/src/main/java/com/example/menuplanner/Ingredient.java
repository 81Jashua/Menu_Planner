package com.example.menuplanner;

import java.io.Serializable;

public class Ingredient implements Serializable {
    public String id;
    public String name;
    public Boolean cold;
    public String location;
    public float price;
    public String store;

    public Ingredient(String name, Boolean cold, String location, float price, String store) {
        this.name = name;
        this.cold = cold;
        this.location = location;
        this.price = price;
        this.store = store;
    }

    public Ingredient(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getCold() {
        return cold;
    }

    public void setCold(Boolean cold) {
        cold = cold;
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

    @Override
    public String toString() {
        return this.name;
    }
}