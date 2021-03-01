package com.example.menuplanner;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FireBase {

    public static void dbTest()
    {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String, Object> ingredient = new HashMap<>();
        ingredient.put("Name", "Salt");
        ingredient.put("Cold", false);
        ingredient.put("Location", "");
        ingredient.put("Price", 3.50);
        ingredient.put("Store", "Costco");

        Map<String, Object> ingredient1 = new HashMap<>();
        ingredient1.put("Name", "Eggs");
        ingredient1.put("Cold", true);
        ingredient1.put("Location", "");
        ingredient1.put("Price", 0.00);
        ingredient1.put("Store", "Costco");

        Map<String, Object> recipe = new HashMap<>();
        recipe.put("Name", "French Toast");
        recipe.put("IsSide", false);
        recipe.put("listExample", Arrays.asList(ingredient, ingredient1));
        //recipe.put("Ingredients", new Map[]{ingredient, ingredient1});

        db.collection("Recipe")
                .add(recipe)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("JCS", "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e("JCS", "THIS IS NOT WORKING!!!!");
                    }
                });
    }
}
