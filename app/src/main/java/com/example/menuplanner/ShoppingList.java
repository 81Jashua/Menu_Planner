package com.example.menuplanner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ShoppingList extends AppCompatActivity {

    //Need to connect to firebase on this line, Url is the param to the getInstance method
    //we  have firebase to use instead of getting reference
    //firebase.getShoppingList(); returns shopping list.

    //FirebaseDatabase database = FirebaseDatabase.getInstance();
    //DatabaseReference ref = database.getReference("Ingredient");
    public ListView listView;
    private List<Ingredient> shoppingList = new ArrayList<>();
    public ArrayAdapter<String> arrayAdapter;

   // FirebaseDatabase database = FirebaseDatabase.getInstance();
   // DatabaseReference ref = database.getReference("Ingredient");

    public List<Ingredient> getIngredient() {return shoppingList;}

    public void setShoppingList(List<Ingredient> shoppingList) {
        this.shoppingList = shoppingList;
        ArrayAdapter arrayAdapter = new ArrayAdapter (this, android.R.layout.simple_list_item_1, shoppingList);
        listView.setAdapter(arrayAdapter);
    }

    /***
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //changes header for activity
        this.setTitle("Shopping List");
    }

        public void displayRecipeScreen(View HomeRecipeButton) {
            Intent recipeIntent = new Intent(this, RecipeActivity.class);
            startActivity(recipeIntent);
            Log.i("display recipe", "opening recipe screen");
        }

        public void displayIngredientsListScreen(View homeIngredientButton) {
            Intent ingredientListIntent = new Intent(this, IngredientListActivity.class);
            startActivity(ingredientListIntent);
            Log.i("display ingredient", "opening ingredient screen");
        }

        public void displayMenuListScreen (View HomeMenuButton) {
            Intent menuItemIntent = new Intent(this, MenuActivity.class);
            startActivity(menuItemIntent);
            Log.i("display menu", "opening menu screen");
        }


        /**
>>>>>>> 6705b08624f8f4d46855a3cbd8f726edcb56ec20
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                // Here is where I am checking that data comes from firebase, before adding to list view.
                String val = Objects.requireNonNull(dataSnapshot.getValue()).toString();
                Log.i("Data from firebase was", val);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {


            }

        });
         */
    }
