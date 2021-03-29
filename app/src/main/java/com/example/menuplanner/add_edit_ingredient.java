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

public class add_edit_ingredient extends AppCompatActivity implements Serializable {
    private Ingredient ingredient;
    private boolean isAdd;

    TextView NametextView;
    TextView StoretextView;
    TextView LocationTextView;
    TextView isColdTextView;
    TextView PriceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_ingredient);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        this.setTitle("Edit Ingredient");

        if (getIntent().getExtras() != null)
        {
            ingredient = (Ingredient) getIntent().getSerializableExtra("Ingred");
            isAdd = getIntent().getBooleanExtra("Add", false);

            NametextView = findViewById(R.id.editTextName);
            StoretextView = findViewById(R.id.editTextStore);
            LocationTextView = findViewById(R.id.editTextLocation);
            isColdTextView = findViewById(R.id.editTextIsCold);
            PriceTextView = findViewById(R.id.editTextPrice);

            if (!isAdd) {
                String price = String.valueOf(ingredient.getPrice());

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

    }

    public void OnClickCancel(View view) { this.finish(); }

    public void OnClickSave(View view) {
         Ingredient editedIngredient = new Ingredient();

            editedIngredient.setName(NametextView.getText().toString());
            editedIngredient.setStore(StoretextView.getText().toString());
            editedIngredient.setLocation(LocationTextView.getText().toString());

            if (PriceTextView.getText().toString().isEmpty())
                editedIngredient.setPrice(0);
            else {
                float price = Float.parseFloat(PriceTextView.getText().toString());
                editedIngredient.setPrice(price);
            }

            if (isColdTextView.getText().toString().equals("yes"))
                editedIngredient.setCold(true);
            else
                editedIngredient.setCold(false);

         if (!isAdd) {
             editedIngredient.setId(ingredient.getId());
             FireBase.editIngredient(editedIngredient);
         }
         else
             FireBase.addNewIngredient(editedIngredient);


        this.finish();
    }

    public void OnClickDelete(View View)
    {
        if (ingredient != null) {
            FireBase.deleteIngredient(ingredient);
            this.finish();
        }
        else
            this.finish();
    }

}