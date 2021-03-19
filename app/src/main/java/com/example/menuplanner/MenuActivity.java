package com.example.menuplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //changes header for activity
        this.setTitle("Menu");

        //sets back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Edit button to add or remove recipes
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.menuFAB);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("FAB is Clicked");
                Log.d("menu fab", "onClick: fab button clicked");
            }
        });
    }
}