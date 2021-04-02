package com.example.menuplanner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ShoppingList extends AppCompatActivity implements AdapterView.OnItemClickListener, Serializable {

    private List<Ingredient> menuRecipes = new ArrayList<>();
    public ListView MenuListView;
    public ArrayAdapter menuAdapter;

    public List<Ingredient> getMenu() { return menuRecipes;
    }

    public void setUpMenuListView() {
        menuAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,menuRecipes);
        MenuListView = (ListView) findViewById(R.id.listViewShoppingList);
        MenuListView.setAdapter(menuAdapter);
        MenuListView.setOnItemClickListener(this);
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

    /**when this list item is clicked, it is not to add, but to edit. Gives option for
     * user to delete.
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Ingredient ingredient =  menuRecipes.get(position);
        Intent itemClickIntent = new Intent(this, add_edit_ingredient.class);
        itemClickIntent.putExtra("Ingred", ingredient);
        itemClickIntent.putExtra("Add", false);
        startActivity(itemClickIntent);
    }
}
