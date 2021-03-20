package com.example.menuplanner;

import java.util.Arrays;

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

    public Recipe(){

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

    @Override
    public String toString() {
        return "Recipe{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", isSide=" + isSide +
                ", ingredients=" + Arrays.toString(ingredients) +
                '}';
    }
}
