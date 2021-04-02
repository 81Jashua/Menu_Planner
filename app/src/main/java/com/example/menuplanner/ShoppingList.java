package com.example.menuplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ShoppingList extends AppCompatActivity {

    private List<String> shoppingListIngredients = new ArrayList<String>();
    public ListView ShoppingListView;
    public ArrayAdapter adapter;
    private Button clearAllButton;



    public List<String> getShoppingList() {
        return shoppingListIngredients;
    }

    public void setUpShoppingListView() {
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, shoppingListIngredients);
        ShoppingListView = (ListView) findViewById(R.id.listViewShoppingList);
        ShoppingListView.setAdapter(adapter);
    }

    /***
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //changes header for activity
        this.setTitle("Shopping List");
        FireBase.getAllShoppingIngredients(this);
        Log.d("Test", "Are we getting recipes?");

        //set up for clearing shopping list
        clearAllButton = (Button) findViewById(R.id.clearAllIngredients);

    }

    public void onClearButtonClick(View view) {
        Log.d("EMR", "clicked clear all ingredients");
        shoppingListIngredients.clear();
        adapter.notifyDataSetChanged();


    }



    @Override
    protected void onResume() {
        super.onResume();
        FireBase.getAllShoppingIngredients(this);
    }

    /**
     * When an ingredient is selected, add_edit_ingredient displays all data for the ingredient.
     * User can edit ingredient.
     * @param editIngredientButton
     */
    public void displayedIngredientScreen(View editIngredientButton)
    {
        Intent addIngredientIntent = new Intent(this, add_edit_ingredient.class);
        addIngredientIntent.putExtra("Add", true);
        startActivity(addIngredientIntent);
        Log.i("Display Edit Ingredient", "Opening edit ingredient Screen");
    }


    /**
     * nav button to display recipe activity
      * @param HomeRecipeButton
     */
    public void displayRecipeScreen(View HomeRecipeButton) {
        Intent recipeIntent = new Intent(this, RecipeActivity.class);
        startActivity(recipeIntent);
        Log.i("display recipe", "opening recipe screen");
    }

    /**
     * nav button to display ingredientlist activity
     * @param homeIngredientButton
     */
    public void displayIngredientsListScreen(View homeIngredientButton) {
        Intent ingredientListIntent = new Intent(this, IngredientListActivity.class);
        startActivity(ingredientListIntent);
        Log.i("display ingredient", "opening ingredient screen");
    }

    /**
     * nav button to display menu activity
     * @param HomeMenuButton
     */
    public void displayMenuListScreen(View HomeMenuButton) {
        Intent menuItemIntent = new Intent(this, MenuActivity.class);
        startActivity(menuItemIntent);
        Log.i("display menu", "opening menu screen");
    }


}