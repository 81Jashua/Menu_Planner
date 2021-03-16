package com.example.menuplanner;

public class Recipe {
    public String id;
    public String name;
    public boolean isSide;
    public Ingredient[] ingredients;

    public Recipe(String id, String name, boolean isSide, Ingredient[] ingredients) {
        this.id = id;
        this.name = name;
        this.isSide = isSide;
        this.ingredients = ingredients;
    }
}
