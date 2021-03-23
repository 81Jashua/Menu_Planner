package com.example.menuplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {
    private List<Recipe> recipes = new ArrayList<>();
    public ListView listView;
    public ArrayAdapter adapter;

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
        listView = (ListView) findViewById(R.id.listViewMenuList);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //changing color of header
        int headerColor = Color.parseColor("#89C2D9");
        getWindow().setStatusBarColor(headerColor);
        //changes header for activity
        this.setTitle("Menu");

        //sets back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}