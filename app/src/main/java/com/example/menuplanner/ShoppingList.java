package com.example.menuplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShoppingList extends AppCompatActivity implements AdapterView.OnItemClickListener, Serializable {

    private List<Ingredient> shoppingListIngredients = new ArrayList<Ingredient>();
    public ListView ShoppingListView;
    public ArrayAdapter adapter;
    private boolean deleteFromList;
    private Button deleteIngredientButton;



    public List<Ingredient> getShoppingList() {
        return shoppingListIngredients;
    }

    public void setUpMenuListView() {
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, shoppingListIngredients);
        ShoppingListView = (ListView) findViewById(R.id.listViewShoppingList);
        ShoppingListView.setAdapter(adapter);
        ShoppingListView.setOnItemClickListener(this);
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

        //set up for deleting ingredients from shopping list
        deleteFromList = false;
        deleteIngredientButton = (Button) findViewById(R.id.deleteFromShopping);
        deleteIngredientButton.setText("Delete Ingredient");
    }

    public void onDeleteButtonClick(View view) {
        if (!deleteFromList)
            deleteIngredientButton.setText("Stop");
        else
            deleteIngredientButton.setText("Delete Ingredient");
        deleteFromList = !deleteFromList;
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
        Ingredient deletedIngredient = shoppingListIngredients.get(position);
        if (deleteFromList) {
            shoppingListIngredients.remove(deletedIngredient);
            Log.i("deletion", "Deleted ingredient from shopping list");

        } else {
            //Ingredient ingredient =  shoppingListIngredient.get(position);
            //Intent itemClickIntent = new Intent(this, add_edit_ingredient.class);
            //itemClickIntent.putExtra("Ingred", ingredient);
            //itemClickIntent.putExtra("Add", false);
            //startActivity(itemClickIntent);
        }


    }
}