package com.example.menuplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {



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

        FireBase.dbTest();
    }
    /**Called when user clicks the recipe button*/
    public void displayRecipeScreen(View homeRecipeButton) {
        Intent recipeIntent = new Intent(this, RecipeActivity.class);
        startActivity(recipeIntent);
        Log.i("display recipe", "opening recipe screen");


    }

    public void displayIngredientsListScreen(View homeIngredientButton) {
        Intent ingredientListIntent = new Intent(this, IngredientListActivity.class);
        startActivity(ingredientListIntent);
        Log.i("display ingredient", "opening ingredient screen");
    }

    public void displayMenuListScreen(View homeIngredientButton) {
        Intent menuItemIntent = new Intent(this, MenuActivity.class);
        startActivity(menuItemIntent);
        Log.i("display menu", "opening menu screen");
    }

    public void displayShoppingListScreen(View homeIngredientButton) {
        Intent shoppingListIntent = new Intent(this, ShoppingList.class);
        startActivity(shoppingListIntent);
        Log.i("display shopping list", "opening shopping list screen");
    }
}