package com.example.menuplanner;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FireBase {

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
                "Cold", ingredient.cold,
                "location", ingredient.location,
                "price", ingredient.price,
                "store", ingredient.store);
    }

    public static void deleteIngredient(Ingredient ingredient) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Ingredient").document(ingredient.id).delete();
    }

    public static void getAllRecipeIngredients(Add_Edit_Recipe activity) {
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
                            activity.ingredientList.clear();
                            activity.ingredientList.addAll(ingredients);
                            activity.setUpListView();
                            //activity.setUpDropDown();
                        }
                        else {
                            Log.d("JCS", "Error getting documents: ", task.getException());
                        }
                    }
                });

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
                "Side", recipe.side
                //"Ingredients", recipe.ingredients
        );
    }

    public static void deleteRecipe(Recipe recipe) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Recipe").document(recipe.id).delete();
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
                                Recipe recipe = document.toObject(Recipe.class);
                                recipe.setId(document.getId());
                                recipes.add(recipe);
                                Log.d("JCS", document.getId() + " => " + document.getData());
                            }
                            recAct.getRecipes().clear();
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
    public static void deleteMenuItem(Recipe recipe) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Menu").document(recipe.id).delete();
    }

    public static void getAllRecipes(MenuActivity menu) {
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
                            menu.getRecipes().clear();
                            menu.getRecipes().addAll(recipes);
                            menu.setUpListView();
                            menu.recipeAdapter.notifyDataSetChanged();
                        }
                        else {
                            Log.d("JCS", "Error getting documents: ", task.getException());
                        }
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
                                recipe.setId(document.getId());
                                recipes.add(recipe);

                                Log.d("JCS", document.getId() + " => " + document.getData());
                            }
                            menuActivity.getMenu().clear();
                            menuActivity.getMenu().addAll(recipes);
                            menuActivity.setUpMenuListView();
                            menuActivity.menuAdapter.notifyDataSetChanged();
                        }
                        else {
                            Log.d("JCS", "Error getting documents: ", task.getException());
                        }
                    }
                });
    }

    public static void getAllShoppingIngredients(ShoppingList shoppingList) {
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
                            List<String> ingredients = new ArrayList<>();

                            shoppingList.getMenu().clear();
                            shoppingList.getMenu().addAll(recipes);
                            shoppingList.setUpMenuListView();
                            shoppingList.menuAdapter.notifyDataSetChanged();
                        }
                        else {
                            Log.d("JCS", "Error getting documents: ", task.getException());
                        }
                    }
                });
    }
}
