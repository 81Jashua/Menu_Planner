package com.example.menuplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Add_Edit_Recipe extends AppCompatActivity implements AdapterView.OnItemClickListener, Serializable {
    private Recipe recipe;
    private Ingredient ingredient;
    public List<Ingredient> ingredientList = new ArrayList<Ingredient>();
    private ArrayAdapter adapter;
    private boolean addToRecipe = false;
    private Button addRecipeButton;
    public ListView listView;

    EditText isSide;
    EditText NametextView;
    EditText StoretextView;
    EditText LocationTextView;
    EditText isColdTextView;
    EditText PriceTextView;

    public void setUpListView()
    {
        //ingredientAdapter = new IngredientAdapter(this, android.R.layout.simple_list_item_1, ingredientList);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,ingredientList);
        listView = (ListView) findViewById(R.id.listViewIngredientsList);
        listView.setAdapter(adapter);
    }

    public void onItemClick(AdapterView<?> l, View view, int position, long id) {
        ItemClickOptions(position);
    }


    public void ItemClickOptions(int position)
    {
        Ingredient ingredient = ingredientList.get(position);
        if (addToRecipe) {
            for (Ingredient i : ingredientList) {
                recipe.addIngredient(i.name);
                Log.i("Ingredient", ingredient.name);
            }
            FireBase.addNewRecipe(recipe);
            Log.i("Ingredient was clicked", "Adding Ingredient to recipe");
        }
        else if (!addToRecipe)
        {
            Intent addRecipeIntent = new Intent(this, RecipeActivity.class);
            addRecipeIntent.putExtra("Recipe",recipe);
            startActivity(addRecipeIntent);
            Log.i("Display Edit Recipe", "Opening add recipe Screen");
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__edit__recipe);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        this.setTitle("Add Recipes");

        //FireBase.getAllIngredients(this);
        if (getIntent().getExtras() != null)
        {
            recipe = (Recipe) getIntent().getSerializableExtra("Recipe");
        }
        addRecipeButton = (Button) findViewById(R.id.addToRecipeButton);
        NametextView = (EditText) findViewById(R.id.editTextRecipeName);
        addRecipeButton.setText("Add to Recipe");
        isSide = (EditText) findViewById(R.id.editTextIsSide);


    }

    public void onAddRecipeButtonClick(View View)
    {
        if (!addToRecipe)
            addRecipeButton.setText("Stop");
        else
            addRecipeButton.setText("Add to Menu");

        addToRecipe = !addToRecipe;
    }


    //Drop down list to select ingredients.
    //public void setUpDropDown()
    //{
        //adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ingredientList);
        //Log.i("Ingredient size", String.valueOf(ingredientList.size()));
        //Spinner dropdown = findViewById(R.id.ingredientDropDown1);
        //dropdown.setAdapter(adapter);
        //dropdown.setOnItemSelectedListener(this);
        //adapter.notifyDataSetChanged();
    //}

    @Override
    protected void onResume() {
        super.onResume();
        //FireBase.getAllRecipeIngredients(this);
    }







    public void OnClickCancel(View view) { this.finish(); }

    public void OnClickSave(View view) {
        Recipe addedRecipe = new Recipe();

            addedRecipe.setName(NametextView.getText().toString());
            ingredientList.add(ingredient);
            addedRecipe.setIngredients(new RecipeIngredientList(ingredientList));

            if (isSide.getText().toString().equals("yes"))
                addedRecipe.setSide(true);
            else
                addedRecipe.setSide(false);

            FireBase.addNewRecipe(addedRecipe);

        this.finish();
    }

    public void OnDeleteRecipeClick(View view)
    {
        if (recipe != null) {
            FireBase.deleteRecipe(recipe);
            this.finish();
        }
        else
            this.finish();
    }

    public void displayedIngredientScreen(View editIngredientButton)
    {
        Intent editIngredientIntent = new Intent(this, add_edit_ingredient.class);
        startActivity(editIngredientIntent);
        Log.i("Display Edit Ingredient", "Opening edit ingredient Screen");
    }
}