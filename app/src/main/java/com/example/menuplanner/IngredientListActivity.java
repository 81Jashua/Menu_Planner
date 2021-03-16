package com.example.menuplanner;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class IngredientListActivity extends AppCompatActivity {
    private ArrayList<Ingredient> ingredientList;

    //database references if needed
    //final FirebaseDatabase database = FirebaseDatabase.getInstance();
    //private DatabaseReference ingredientDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //changes header for activity
        this.setTitle("Ingredients");

        ingredientList = new ArrayList<>();

        //edited by Jacob
        // attempts to access firebase class and populate ingredientList for listview
        //need to figure out how to access database information from other classes
        //ingredientDatabase = database.getReference();
       // addIngredientEventListener(ingredientDatabase);

        //arrayAdpater for ingredients listview
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),R.layout.list_ingredients,ingredientList);
        ListView listview = findViewById(R.id.listViewIngredientsList);
        listview.setAdapter(adapter);

    }

    public void displayeditIngredientScreen(View editIngredientButton)
    {
        Intent editIngredientIntent = new Intent(this, add_edit_ingredient.class);
        startActivity(editIngredientIntent);
        Log.i("Display Edit Ingredient", "Opening edit ingredient Screen");
    }

    /**
     * add Ingredient Event Listener if used to read information from Database.
     *  As soon as I can connect to a database, this might be useful.
     * note, currently doesn't do anything until called
     *
     * @author Jacob
     * @param mIngredientReference
     */
    private void addIngredientEventListener(DatabaseReference mIngredientReference) {
        ValueEventListener ingredientListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.i("Ingredients List Activity", "onDataChange: pulling ingredients from database");
                Ingredient ingredient = dataSnapshot.getValue(Ingredient.class);
                Log.i("add Event Lister Complete", "Ingredient Data Saved");
                ingredientList.add(ingredient);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("loadPost:Cancelled", databaseError.toException());
            }
        };
        mIngredientReference.addValueEventListener(ingredientListener);
    }
}