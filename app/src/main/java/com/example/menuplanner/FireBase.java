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

        Map<String, Object> butterIngredient = new HashMap<>();
        butterIngredient.put("Name", "Butter");
        butterIngredient.put("Cold", true);
        butterIngredient.put("Location", "");
        butterIngredient.put("Price", 0.00);
        butterIngredient.put("Store", "WalMart");

        Map<String, Object> onionIngredient = new HashMap<>();
        onionIngredient.put("Name", "Onion");
        onionIngredient.put("Cold", false);
        onionIngredient.put("Location", "");
        onionIngredient.put("Price", 0.00);
        onionIngredient.put("Store", "WalMart");

        Map<String, Object> celeryIngredient = new HashMap<>();
        celeryIngredient.put("Name", "Celery");
        celeryIngredient.put("Cold", true);
        celeryIngredient.put("Location", "");
        celeryIngredient.put("Price", 0.00);
        celeryIngredient.put("Store", "WalMart");

        Map<String, Object> greenPepperIngredient = new HashMap<>();
        greenPepperIngredient.put("Name", "Green Pepper");
        greenPepperIngredient.put("Cold", false);
        greenPepperIngredient.put("Location", "");
        greenPepperIngredient.put("Price", 0.00);
        greenPepperIngredient.put("Store", "WalMart");

        Map<String, Object> tomatoIngredient = new HashMap<>();
        tomatoIngredient.put("Name", "Tomato");
        tomatoIngredient.put("Cold", false);
        tomatoIngredient.put("Location", "");
        tomatoIngredient.put("Price", 0.00);
        tomatoIngredient.put("Store", "WalMart");

        Map<String, Object> chickenBrothIngredient = new HashMap<>();
        chickenBrothIngredient.put("Name", "Chicken Broth");
        chickenBrothIngredient.put("Cold", false);
        chickenBrothIngredient.put("Location", "");
        chickenBrothIngredient.put("Price", 0.00);
        chickenBrothIngredient.put("Store", "WalMart");

        Map<String, Object> chickenBreastIngredient = new HashMap<>();
        chickenBrothIngredient.put("Name", "Chicken Breast");
        chickenBrothIngredient.put("Cold", true);
        chickenBrothIngredient.put("Location", "");
        chickenBrothIngredient.put("Price", 0.00);
        chickenBrothIngredient.put("Store", "WalMart");

        Map<String, Object> italianSausageIngredient = new HashMap<>();
        italianSausageIngredient.put("Name", "Italian Sausage");
        italianSausageIngredient.put("Cold", true);
        italianSausageIngredient.put("Location", "");
        italianSausageIngredient.put("Price", 0.00);
        italianSausageIngredient.put("Store", "WalMart");

        Map<String, Object> shrimpIngredient = new HashMap<>();
        shrimpIngredient.put("Name", "Shrimp");
        shrimpIngredient.put("Cold", true);
        shrimpIngredient.put("Location", "");
        shrimpIngredient.put("Price", 0.00);
        shrimpIngredient.put("Store", "WalMart");

        Map<String, Object> recipe = new HashMap<>();
        recipe.put("Name", "French Toast");
        recipe.put("IsSide", false);
        recipe.put("listExample", Arrays.asList(ingredient, ingredient1));
        //recipe.put("Ingredients", new Map[]{ingredient, ingredient1});

        Map<String, Object> jambalayaRecipe = new HashMap<>();
        jambalayaRecipe.put("Name", "Jambalaya");
        jambalayaRecipe.put("IsSide", false);
        jambalayaRecipe.put("listExample", Arrays.asList(butterIngredient, onionIngredient, celeryIngredient, greenPepperIngredient, tomatoIngredient,
                chickenBrothIngredient, chickenBreastIngredient, italianSausageIngredient, shrimpIngredient));

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
