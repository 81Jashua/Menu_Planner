package com.example.menuplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuAdapter;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private List<Recipe> recipes = new ArrayList<>();
    private List<Recipe> menuRecipes = new ArrayList<>();
    public ListView RecipelistView;
    public ListView MenuListView;
    public ArrayAdapter recipeAdapter;
    public ArrayAdapter menuAdapter;

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public List<Recipe> getMenu()
    {
        return menuRecipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
        recipeAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,recipes);
        RecipelistView = (ListView) findViewById(R.id.MenuRecipeView);
        RecipelistView.setAdapter(recipeAdapter);
    }

    public void setUpListView()
    {
       recipeAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,recipes);
       RecipelistView = (ListView) findViewById(R.id.MenuRecipeView);
       RecipelistView.setAdapter(recipeAdapter);
       RecipelistView.setOnItemClickListener(this);
    }

    public void setUpMenuListView()
    {
        menuAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,menuRecipes);
        MenuListView = (ListView) findViewById(R.id.listViewMenuList);
        MenuListView.setAdapter(menuAdapter);
        MenuListView.setOnItemClickListener(this);
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

        //sets back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        FireBase.getAllRecipes(this);
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Log.d("JTS", "test");
        Recipe recipe = new Recipe();
        switch(parent.getId())
        {
            case R.id.MenuRecipeView:
                recipe = recipes.get(position);
                FireBase.addMenuItem(recipe);
                recipes.remove(recipe);
                menuRecipes.add(recipe);
                recipeAdapter.notifyDataSetChanged();
                menuAdapter.notifyDataSetChanged();
                FireBase.getAllMenuItems(this);
                break;
            case R.id.listViewMenuList:
                Log.d("JTS", "got menu");
                recipe = menuRecipes.get(position);
                FireBase.deleteMenuItem(recipe);
                menuRecipes.remove(recipe);
                recipes.add(recipe);
                recipeAdapter.notifyDataSetChanged();
                menuAdapter.notifyDataSetChanged();
                break;
        }

    }
}