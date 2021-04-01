package com.example.menuplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Add_Edit_Recipe extends AppCompatActivity implements AdapterView.OnItemClickListener, Serializable {
    private Recipe recipe;
    public List<Ingredient> ingredientList = new ArrayList<Ingredient>();
    public List<Ingredient> addedIngredientList = new ArrayList<>();
    private ArrayAdapter adapter;
    private ArrayAdapter addedAdapter;
    private boolean editRecipe;
    public ListView IngredientlistView;
    public ListView AddedIngredientListView;

    EditText isSide;
    EditText NametextView;

    public void setUpListView()
    {
        //ingredientAdapter = new IngredientAdapter(this, android.R.layout.simple_list_item_1, ingredientList);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,ingredientList);
        IngredientlistView = (ListView) findViewById(R.id.listViewRecipeIngredientList);
        IngredientlistView.setAdapter(adapter);
        IngredientlistView.setOnItemClickListener(this);
    }

    public void setUpAddedListView()
    {
        addedAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, addedIngredientList);
        AddedIngredientListView = (ListView) findViewById(R.id.listViewAddedIngredientList);
        AddedIngredientListView.setAdapter(addedAdapter);
        AddedIngredientListView.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("JTS", "test");
        Ingredient ingredient;
        switch(parent.getId())
        {
            case R.id.listViewRecipeIngredientList:
                ingredient = ingredientList.get(position);
                ingredientList.remove(ingredient);
                addedIngredientList.add(ingredient);
                adapter.notifyDataSetChanged();
                addedAdapter.notifyDataSetChanged();
                break;
            case R.id.listViewAddedIngredientList:
                Log.d("JTS", "got menu");
                ingredient = addedIngredientList.get(position);
                addedIngredientList.remove(ingredient);
                ingredientList.add(ingredient);
                adapter.notifyDataSetChanged();
                addedAdapter.notifyDataSetChanged();
                break;
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
            editRecipe = getIntent().getBooleanExtra("Edit", false);
        }
        NametextView = (EditText) findViewById(R.id.editTextRecipeName);
        isSide = (EditText) findViewById(R.id.editTextIsSide);

        ingredientList.clear();
        addedIngredientList.clear();
        if (editRecipe) {
            addedIngredientList = recipe.getIngredients().getIngredientList();
            NametextView.setText(recipe.getName());

            if (recipe.side)
                isSide.setText("yes");
            else
                isSide.setText("no");
        }

        setUpAddedListView();


    }

    @Override
    protected void onResume() {
        super.onResume();
        FireBase.getAllRecipeIngredients(this);
    }

    public void OnClickCancel(View view) { this.finish(); }

    public void OnClickSave(View view) {
        Recipe addedRecipe = new Recipe();

        addedRecipe.setName(NametextView.getText().toString());
        addedRecipe.setIngredients(new RecipeIngredientList(addedIngredientList));

        if (isSide.getText().toString().equals("yes"))
            addedRecipe.setSide(true);
        else
            addedRecipe.setSide(false);

        if (editRecipe) {
            addedRecipe.setId(recipe.getId());
            FireBase.editRecipe(addedRecipe);
        }
        else
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
        editIngredientIntent.putExtra("Add", true);
        startActivity(editIngredientIntent);
        Log.i("Display Edit Ingredient", "Opening edit ingredient Screen");
    }
}