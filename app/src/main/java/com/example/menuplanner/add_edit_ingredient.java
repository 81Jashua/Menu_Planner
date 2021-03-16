package com.example.menuplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class add_edit_ingredient extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_ingredient);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        this.setTitle("Edit Ingredient");
    }

    public void OnClickCancel(View view) { this.finish(); }

    public void OnClickSave(View view) { this.finish(); }
}