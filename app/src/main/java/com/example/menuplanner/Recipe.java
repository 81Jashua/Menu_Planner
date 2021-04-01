package com.example.menuplanner;

import java.io.Serializable;
import java.util.Arrays;

public class Recipe implements Serializable {
    public String id;
    public String name;
    public boolean side;
    public RecipeIngredientList ingredients;

    public Recipe(){}

    public Recipe(String name, boolean side, RecipeIngredientList ingredients) {
        this.name = name;
        this.side = side;
        this.ingredients = ingredients;
    }

    public void addIngredient(String ingredientName){
        this.ingredients.getIngredientList().add(new Ingredient(ingredientName, true, "", 0,""));
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
        return side;
    }

    public void setSide(boolean side) {
        this.side = side;
    }

    public RecipeIngredientList getIngredients() {
        return ingredients;
    }

    public void setIngredients(RecipeIngredientList ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
