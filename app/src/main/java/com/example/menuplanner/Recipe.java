package com.example.menuplanner;

public class Recipe {
    public String id;
    public String name;
    public boolean isSide;
    public Ingredient[] ingredients;

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

    public boolean isSide() {
        return isSide;
    }

    public void setSide(boolean side) {
        isSide = side;
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredient[] ingredients) {
        this.ingredients = ingredients;
    }
}
