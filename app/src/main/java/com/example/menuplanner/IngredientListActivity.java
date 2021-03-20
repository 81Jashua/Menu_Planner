package com.example.menuplanner;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class IngredientListActivity extends AppCompatActivity {
    public List<Ingredient> ingredientList = new ArrayList<Ingredient>();
    public ListView listView;
    public IngredientAdapter ingredientAdapter;
    public ArrayAdapter adapter;

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

       FireBase.getAllIngredients(this);

        Log.d("JTS", "Testing ingredient list pull");
    }


    public void displayeditIngredientScreen(View editIngredientButton)
    {
        Intent editIngredientIntent = new Intent(this, add_edit_ingredient.class);
        startActivity(editIngredientIntent);
        Log.i("Display Edit Ingredient", "Opening edit ingredient Screen");
    }

    public void setUpListView()
    {
        //ingredientAdapter = new IngredientAdapter(this, android.R.layout.simple_list_item_1, ingredientList);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,ingredientList);
        listView = (ListView) findViewById(R.id.listViewIngredientsList);
        listView.setAdapter(adapter);
    }

}