package com.example.menuplanner;

public class Ingredient {

    private String id;
    private boolean hot;
    private String name;
    private boolean cold;
    private float price;

    public Ingredient(String id, boolean hot, String name, boolean cold, float price) {
        this.id = id;
        this.hot = hot;
        this.name = name;
        this.cold = cold;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isHot() {
        return hot;
    }

    public void setHot(boolean hot) {
        this.hot = hot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCold() {
        return cold;
    }

    public void setCold(boolean cold) {
        this.cold = cold;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
