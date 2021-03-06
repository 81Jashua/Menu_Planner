package com.example.menuplanner;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class IngredientListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, Serializable {

    public List<Ingredient> ingredientList = new ArrayList<Ingredient>();
    public ListView listView;
    //public IngredientAdapter ingredientAdapter;
    public ArrayAdapter adapter;

    //database references if needed
    //final FirebaseDatabase database = FirebaseDatabase.getInstance();
    //private DatabaseReference ingredientDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //changes header for activity
        this.setTitle("Ingredients");

        FireBase.getAllIngredients(this);

        Log.d("JTS", "Testing ingredient list pull");
    }

    @Override
    protected void onResume() {
        super.onResume();
        //FireBase.getAllIngredients(this);
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
     * When user selects an ingredient inside the list, the position of the item is stored to
     * enable user to edit that selected ingredient
     * @param l
     * @param view
     * @param position
     * @param id
     */
    public void onItemClick(AdapterView<?> l, View view, int position, long id)
    {
        Ingredient ingredient = ingredientList.get(position);
        Intent itemClickIntent = new Intent(this, add_edit_ingredient.class);
        itemClickIntent.putExtra("Ingred", ingredient);
        itemClickIntent.putExtra("Add", false);
        startActivity(itemClickIntent);
    }

    /**
     *populates listview for ingredients
     */
    public void setUpListView()
    {
        //ingredientAdapter = new IngredientAdapter(this, android.R.layout.simple_list_item_1, ingredientList);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,ingredientList);
        listView = (ListView) findViewById(R.id.listViewIngredientsList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }


    public List<Ingredient> getIngredientList()
    {
        return ingredientList;
    }

    /**
     * nav button to recipe activity
     * @param HomeRecipeButton
     */
    public void displayRecipeScreen(View HomeRecipeButton) {
        Intent recipeIntent = new Intent(this, RecipeActivity.class);
        startActivity(recipeIntent);
        Log.i("display recipe", "opening recipe screen");
    }

    /**
     * nav button to menu activity
     * @param HomeMenuButton
     */
    public void displayMenuListScreen(View HomeMenuButton) {
        Intent menuItemIntent = new Intent(this, MenuActivity.class);
        startActivity(menuItemIntent);
        Log.i("display menu", "opening menu screen");
    }

    /**
     * nav button to shopping list activity
     * @param HomeIngredientButton
     */
    public void displayShoppingListScreen(View HomeIngredientButton) {
        Intent shoppingListIntent = new Intent(this, ShoppingList.class);
        startActivity(shoppingListIntent);
        Log.i("display shopping list", "opening shopping list screen");
    }

}