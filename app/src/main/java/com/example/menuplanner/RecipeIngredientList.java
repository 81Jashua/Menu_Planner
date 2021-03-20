package com.example.menuplanner;

import java.util.ArrayList;
import java.util.List;

public class RecipeIngredientList {

    List<Ingredient> ingredientList = new ArrayList<>();

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public RecipeIngredientList(){}

    public RecipeIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }
}
