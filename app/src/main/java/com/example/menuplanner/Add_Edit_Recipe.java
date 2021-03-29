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
import android.widget.Spinner;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Add_Edit_Recipe extends AppCompatActivity implements AdapterView.OnItemSelectedListener, Serializable {
    public ArrayAdapter adapter;
    private Recipe recipe;
    private Ingredient ingredient;

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
        //get the spinner from the xml.
        Spinner dropdown = findViewById(R.id.ingredientDropDown1);
//create a list of items for the spinner.
        String[] items = new String[]{"1", "2", "three"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, recipe.getIngredients().getIngredientList());
//set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(this);

    }

    public void OnClickCancel(View view) { this.finish(); }

    public void OnClickSave(View view) { this.finish(); }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        parent.getItemAtPosition(position);
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