package com.example.menuplanner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class ShoppingList extends AppCompatActivity {

    //Need to connect to firebase on this line, Url is the param to the getInstance method
    //we  have firebase to use instead of getting reference
    //firebase.getShoppingList(); returns shopping list.

    //FirebaseDatabase database = FirebaseDatabase.getInstance();
    //DatabaseReference ref = database.getReference("Ingredient");
    //ListView listView;
    //ArrayList<String> arrayList = new ArrayList<>();
    //ArrayAdapter<String> arrayAdapter;

   // FirebaseDatabase database = FirebaseDatabase.getInstance();
   // DatabaseReference ref = database.getReference("Ingredient");

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

//        listView = (ListView) findViewById(R.id.shoppingRecyclerView);
//        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.activity_list_item);
//        listView.setAdapter(arrayAdapter);

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
}