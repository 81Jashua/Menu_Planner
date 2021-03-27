package com.example.menuplanner;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FireBase {

    public static void dbTest(Ingredient ingredient)
    {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String, Object> ingredient0 = new HashMap<>();
        ingredient0.put("Name", "Salt");
        ingredient0.put("Cold", false);
        ingredient0.put("Location", "");
        ingredient0.put("Price", 3.50);
        ingredient0.put("Store", "Costco");

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

        db.collection("Ingredient")
                .add(ingredient)
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

    public static void addNewIngredient(Object ingredient) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Ingredient")
                .add(ingredient)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("JCS", "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e("JCS", "Ingredient not added");
                    }
                });
    }

    public static void editIngredient(Ingredient ingredient) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Ingredient").document(ingredient.id).update(
                "name", ingredient.name,
                "isCold", ingredient.isCold,
                "location", ingredient.location,
                "price", ingredient.price,
                "store", ingredient.store);
    }

    public static void deleteIngredient(Ingredient ingredient) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Ingredient").document(ingredient.id).delete();
    }

    public static void getAllIngredients(IngredientListActivity ingredAct) {
        List<Ingredient> ingredients = new ArrayList<>();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Ingredient")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                // ingredients.add(document.toObject(Ingredient.class));
                                Ingredient ingredient = document.toObject(Ingredient.class);
                                ingredient.setId(document.getId());
                                ingredients.add(ingredient);
                               // ingredients.add(document.toObject(Ingredient.class));
                                Log.d("JCS", document.getId() + " => " + document.getData());
                            }
                            ingredAct.ingredientList.clear();
                            ingredAct.ingredientList.addAll(ingredients);
                            ingredAct.setUpListView();
                           // ingredAct.ingredientAdapter.notifyDataSetChanged();
                            ingredAct.adapter.notifyDataSetChanged();
                        }
                        else {
                            Log.d("JCS", "Error getting documents: ", task.getException());
                        }
                    }
                });

    }

    public static void addNewRecipe(Object recipe) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("Recipe")
                .add(recipe)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("JCS", "Recipe added");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e("JCS", "Recipe was not added");
                    }
                });
    }

    public static void editRecipe(Recipe recipe) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Recipe").document(recipe.id).update(
                "name", recipe.name,
                "isSide", recipe.isSide
                //"Ingredients", recipe.ingredients
        );
    }

    public static void getAllRecipes(RecipeActivity recAct) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Recipe")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            List<Recipe> recipes = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                recipes.add(document.toObject(Recipe.class));
                                Log.d("JCS", document.getId() + " => " + document.getData());
                            }
                            recAct.getRecipes().addAll(recipes);
                            recAct.setUpListView();
                            recAct.adapter.notifyDataSetChanged();
                        }
                        else {
                            Log.d("JCS", "Error getting documents: ", task.getException());
                        }
                    }
                });
    }

    public static void addMenuItem(Object recipe) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("Menu")
                .add(recipe)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("JCS", "Menu item added");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e("JCS", "Menu item was not added");
                    }
                });
    }

    public static void getAllMenuItems(MenuActivity menuActivity) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Menu")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            List<Recipe> recipes = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Recipe  recipe = document.toObject(Recipe.class);
                                recipes.add(recipe);

                                Log.d("JCS", document.getId() + " => " + document.getData());
                            }
                            menuActivity.getRecipes().addAll(recipes);
                            menuActivity.setUpListView();
                            menuActivity.adapter.notifyDataSetChanged();
                        }
                        else {
                            Log.d("JCS", "Error getting documents: ", task.getException());
                        }
                    }
                });
    }
}
