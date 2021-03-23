package com.example.menuplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class add_edit_ingredient extends AppCompatActivity {
    private Ingredient ingredient;

    EditText NametextView;
    EditText StoretextView;
    EditText LocationTextView;
    EditText isColdTextView;
    EditText PriceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_ingredient);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        this.setTitle("Edit Ingredient");

        if (getIntent().getExtras() != null)
        {
            ingredient = (Ingredient) getIntent().getSerializableExtra("Ingred");

            String price = String.valueOf(ingredient.getPrice());

            NametextView = findViewById(R.id.editTextName);
            StoretextView = findViewById(R.id.editTextStore);
            LocationTextView = findViewById(R.id.editTextLocation);
            isColdTextView = findViewById(R.id.editTextIsCold);
            PriceTextView = findViewById(R.id.editTextPrice);

            NametextView.setText(ingredient.getName());
            StoretextView.setText(ingredient.getStore());
            LocationTextView.setText(ingredient.getLocation());
            PriceTextView.setText(price);

            if (ingredient.getCold())
                isColdTextView.setText("yes");
            else
                isColdTextView.setText("no");

        }

    }


    public void OnClickCancel(View view) { this.finish(); }

    public void OnClickSave(View view) {
         Ingredient editedIngredient = new Ingredient();

         editedIngredient.setId(ingredient.getId());
         editedIngredient.setName(NametextView.getText().toString());
         editedIngredient.setStore(StoretextView.getText().toString());
         editedIngredient.setLocation(LocationTextView.getText().toString());

         float price = Float.parseFloat(PriceTextView.getText().toString());
         editedIngredient.setPrice(price);

         if (isColdTextView.getText().toString().equals("yes"))
             editedIngredient.setCold(true);
         else
             editedIngredient.setCold(false);

         FireBase.editIngredient(editedIngredient);


        this.finish();
    }
}