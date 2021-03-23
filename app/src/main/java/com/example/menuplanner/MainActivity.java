package com.example.menuplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Ingredient> ingredientList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //changes header for activity
        this.setTitle("Menu Planner");
        testMethod();
    }

    public void testMethod() {
        String hello = "hello";
        String breaked = "Did I break this";
        String Jacob = "hi from Jacob";
        //Becky's Comment
        RecipeIngredientList fToastIngredientList = new RecipeIngredientList();
        //fToastIngredientList.getIngredientList().add(new Ingredient("nutella", false, "", (float) 0.00, "Costco"));
        Recipe recipe = new Recipe("French Toast", false, fToastIngredientList);

        //FireBase.addNewRecipe(recipe);
        // Commented out firebase tests
        //Recipe recipe = new Recipe("hED4b6f0yN3RDD7pvEqb", "French Toast", false, new Ingredient[0]);
        //FireBase.dbTest();
        //FireBase.editRecipe(recipe);
        //Ingredient ingredient = new Ingredient("nutella", false, "", (float) 0.00, "Costco");
        //FireBase.dbTest(ingredient);
        //FireBase.getAllIngredients();
        //FireBase.getAllRecipes();
    }
    /**Called when user clicks the recipe button*/
    public void displayRecipeScreen(View HomeRecipeButton) {
        Intent recipeIntent = new Intent(this, RecipeActivity.class);
        startActivity(recipeIntent);
        Log.i("display recipe", "opening recipe screen");
    }

    public void displayIngredientsListScreen(View homeIngredientButton) {
        Intent ingredientListIntent = new Intent(this, IngredientListActivity.class);
        startActivity(ingredientListIntent);
        Log.i("display ingredient", "opening ingredient screen");
    }

    public void displayMenuListScreen(View HomeMenuButton) {
        Intent menuItemIntent = new Intent(this, MenuActivity.class);
        startActivity(menuItemIntent);
        Log.i("display menu", "opening menu screen");
    }

    public void displayShoppingListScreen(View HomeIngredientButton) {
        Intent shoppingListIntent = new Intent(this, ShoppingList.class);
        startActivity(shoppingListIntent);
        Log.i("display shopping list", "opening shopping list screen");
    }
}