package com.example.menuplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //testMethod();
    }

    public void testMethod() {
        String hello = "hello";
        String breaked = "Did I break this";
        String Jacob = "hi from Jacob";
        //Becky's Comment

        FireBase.dbTest();
    }
    /**Called when user clicks the recipe button*/
    public void displayRecipeScreen(View homeRecipeButton) {
        Intent recipeIntent = new Intent(this, RecipeActivity.class);
        startActivity(recipeIntent);


    }
}