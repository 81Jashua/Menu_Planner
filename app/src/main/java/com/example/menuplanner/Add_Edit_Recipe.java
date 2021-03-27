package com.example.menuplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Add_Edit_Recipe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__edit__recipe);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle("Edit Recipes");

    }

    public void OnClickCancel(View view) { this.finish(); }

    public void OnClickSave(View view) { this.finish(); }
}