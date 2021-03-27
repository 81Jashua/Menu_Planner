package com.example.menuplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {
    private List<Recipe> recipes = new ArrayList<>();
    private List<String> recipeNames = new ArrayList<>();
    public ListView listView;
    public ArrayAdapter adapter;

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<String> recipes) {
        this.recipeNames = recipes;
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,recipeNames);
        listView = (ListView) findViewById(R.id.listViewMenuList);
        listView.setAdapter(adapter);
    }

    public void setUpListView()
    {
       adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,recipes);
       listView = (ListView) findViewById(R.id.listViewMenuList);
       listView.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //changing color of header
        int headerColor = Color.parseColor("#607D8B");
        getWindow().setStatusBarColor(headerColor);
        //changes header for activity
        this.setTitle("Menu");
        /*
        if(getIntent().getExtras() != null) {
            ArrayList<String> recipes = getIntent().getExtras().getStringArrayList("Recipes");
            Log.i("recipes intent", recipes.get(0));
            setRecipes(recipes);
        }*/


        //sets back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        FireBase.getAllMenuItems(this);
    }

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


    public void displayShoppingListScreen(View HomeIngredientButton) {
        Intent shoppingListIntent = new Intent(this, ShoppingList.class);
        startActivity(shoppingListIntent);
        Log.i("display shopping list", "opening shopping list screen");
    }
}