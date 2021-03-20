package com.example.menuplanner;

import java.util.Arrays;

public class Recipe {
    public String id;
    public String name;
    public boolean isSide;
    public RecipeIngredientList ingredients;

    public Recipe(){}

    public Recipe(String id, String name, boolean isSide, RecipeIngredientList ingredients) {
        this.id = id;
        this.name = name;
        this.isSide = isSide;
        this.ingredients = ingredients;
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

    public RecipeIngredientList getIngredients() {
        return ingredients;
    }

    public void setIngredients(RecipeIngredientList ingredients) {
        this.ingredients = ingredients;
    }
}
