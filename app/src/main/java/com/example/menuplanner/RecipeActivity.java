package com.example.menuplanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecipeActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, Serializable {
    private List<Recipe> recipes = new ArrayList<Recipe>();
    public ListView listView;
    public ArrayAdapter adapter;
    private Boolean addToMenu;
    private Button addMenuButton;
    Set<String> ingredients = new HashSet<>();
    Set<String> recipeMenuNames = new HashSet<>();

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,recipes);
        listView.setAdapter(arrayAdapter);
    }

    public void setUpListView()
    {
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,recipes);
        listView = (ListView) findViewById(R.id.listViewRecipeList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> l, View view, int position, long id) {
        ItemClickOptions(position);
    }

    public void ItemClickOptions(int position)
    {
        Recipe recipe = recipes.get(position);
        if (addToMenu) {
            for (Ingredient ingredient : recipe.ingredients.getIngredientList()) {
                ingredients.add(ingredient.name);
                Log.i("Ingredient", ingredient.name);
            }
            FireBase.addMenuItem(recipe);
            Log.i("Recipe was clicked", "Adding Recipe to other lists");
        }
        else if (!addToMenu)
        {
            Intent editRecipeIntent = new Intent(this, Add_Edit_Recipe.class);
            editRecipeIntent.putExtra("Recipe",recipe);
            startActivity(editRecipeIntent);
            Log.i("Display Edit Recipe", "Opening edit recipe Screen");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle("Recipes");
        FireBase.getAllRecipes(this);
        Log.d("Test", "Are we getting recipes?");
        addToMenu = false;
        addMenuButton = (Button) findViewById(R.id.addToMenuButton);
        addMenuButton.setText("Add to Menu");

    }
    public void onAddMenuButtonClick(View View)
    {
        if (!addToMenu)
            addMenuButton.setText("Stop");
        else
            addMenuButton.setText("Add to Menu");

        addToMenu = !addToMenu;
    }


    public void displayRecipeScreen(View editRecipeButton)
    {
        Intent addRecipeIntent = new Intent(this, Add_Edit_Recipe.class);
        startActivity(addRecipeIntent);
        Log.i("Display Edit Recipe", "Opening edit recipe Screen");
    }
    public void displayIngredientsListScreen(View homeIngredientButton) {
        Intent ingredientListIntent = new Intent(this, IngredientListActivity.class);
        startActivity(ingredientListIntent);
        Log.i("display ingredient", "opening ingredient screen");
    }

    public void displayMenuListScreen(View HomeMenuButton) {
        Intent menuItemIntent = new Intent(this, MenuActivity.class);
       // ArrayList<String> recipeNames = new ArrayList<>();
       // recipeNames.addAll(recipeMenuNames);
       // menuItemIntent.putStringArrayListExtra("Recipes", recipeNames);
        startActivity(menuItemIntent);
        Log.i("display menu", "opening menu screen");
    }

    public void displayShoppingListScreen(View HomeIngredientButton) {
        Intent shoppingListIntent = new Intent(this, ShoppingList.class);
        //ArrayList<String> ingredientList = new ArrayList<>();
        //ingredientList.addAll(ingredients);
        //shoppingListIntent.putStringArrayListExtra("Ingredients", ingredientList);
        startActivity(shoppingListIntent);
        Log.i("display shopping list", "opening shopping list screen");
    }
}