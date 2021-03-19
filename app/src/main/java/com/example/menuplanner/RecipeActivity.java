package com.example.menuplanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class RecipeActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        //listView=(ListView)findViewById(R.id.listview);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //changes header for activity
        this.setTitle("Recipes");

        //log test to see if recipes will load from database
        //getRecipes();
        List<String> recipe = new ArrayList<>();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Recipe")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                recipe.add(document.getString("Name"));
                                Log.d("JCS", document.getId() + " => " + document.getData());
                            }
                        }
                        else {
                            Log.d("JCS", "Error getting documents: ", task.getException());
                        }
                    }
                });
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,recipe);
        listView.setAdapter(arrayAdapter);

    }
//    public static List<Recipe> getRecipes() {
//
//        return recipe;
//    }
}