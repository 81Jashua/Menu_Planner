package com.example.menuplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Add_Edit_Recipe extends AppCompatActivity implements AdapterView.OnItemSelectedListener, Serializable {
    private Recipe recipe;
    private Ingredient ingredient;
    public List<Ingredient> ingredientList = new ArrayList<Ingredient>();
    private ArrayAdapter adapter;

    EditText NametextView;
    EditText StoretextView;
    EditText LocationTextView;
    EditText isColdTextView;
    EditText PriceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__edit__recipe);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle("Edit Recipes");

        if (getIntent().getExtras() != null)
        {
            recipe = (Recipe) getIntent().getSerializableExtra("Recipe");
        }
        FireBase.getAllIngredients(this);
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

    public void OnClickCancel(View view) { this.finish(); }

    public void OnClickSave(View view) { this.finish(); }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        parent.getItemAtPosition(position);
        Log.i("Ingredient selected", String.valueOf(position));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //no action necessary
    }

    public void displayedIngredientScreen(View editIngredientButton)
    {
        Intent editIngredientIntent = new Intent(this, add_edit_ingredient.class);
        startActivity(editIngredientIntent);
        Log.i("Display Edit Ingredient", "Opening edit ingredient Screen");
    }
}