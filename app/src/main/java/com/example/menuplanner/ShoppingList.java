package com.example.menuplanner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ShoppingList extends AppCompatActivity {

    //Need to connect to firebase on this line, Url is the param to the getInstance method
    //we  have firebase to use instead of getting reference
    //firebase.getShoppingList(); returns shopping list.

    private List<Recipe> recipes = new ArrayList<Recipe>();
    public ListView listView;
    //private List<String> shoppingList = new ArrayList<>();
    public ArrayAdapter adapter;

    public List<Recipe> getRecipes() {
        return recipes;
    }


//    public List<String> getIngredient() {
//        return shoppingList;
//    }

//    public void setShoppingList(List<String> shoppingList) {
//        this.shoppingList = shoppingList;
//        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, shoppingList);
//        listView = (ListView) findViewById(R.id.listViewShoppingList);
//        listView.setAdapter(arrayAdapter);
//    }

    public void setUpListView()
    {
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,recipes);
        listView = (ListView) findViewById(R.id.listViewRecipeList);
        listView.setAdapter(adapter);
        //listView.setOnItemClickListener(this);
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

//        if (getIntent().getExtras() != null) {
//            ArrayList<String> ingredients = getIntent().getExtras().getStringArrayList("Ingredients");
//            shoppingList.addAll(ingredients);
//        }
//        setShoppingList(shoppingList);
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

    public void displayMenuListScreen(View HomeMenuButton) {
        Intent menuItemIntent = new Intent(this, MenuActivity.class);
        startActivity(menuItemIntent);
        Log.i("display menu", "opening menu screen");
    }

}
