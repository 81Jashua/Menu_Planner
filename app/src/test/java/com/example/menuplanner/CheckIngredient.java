package com.example.menuplanner;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CheckIngredient {

    private Set<String> recipeSet = new HashSet<>();

    @Test
    public void is20CharactersMax() {
        boolean result = is20Characters("1234567890kdhjgdksbk");
        Assert.assertEquals(true, result);
    }


    @Test
    public void setDoesNotAcceptDuplicate() {
        // Add non duplicate
        recipeSet.add("egg");
        Assert.assertEquals(1, recipeSet.size());
        // Add same item
        recipeSet.add("egg");
        Assert.assertEquals(1, recipeSet.size());
    }

    @Test
    public void notAcceptNullNameInIngredient() {
        // Make ingredient with non null name
        Ingredient ingredient = new Ingredient("id", true, "Eggs", false, 1.99f);
        // test function
        Assert.assertEquals(true, nameNotNull(ingredient));
        // Make an ingredient with null name
        Ingredient ingredient1 = new Ingredient("id", true, null, false, 1.99f);
        // test the function
        Assert.assertEquals(false, nameNotNull(ingredient1));
    }


    public boolean nameNotNull(Ingredient ingredient) {
        return Objects.nonNull(ingredient.getName());
    }


    public boolean is20Characters(String value) {
        if (value.length() == 20) {
            return true;
        }
        return false;
    }
}
