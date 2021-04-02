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
import java.util.List;

public class FireBase {
    /**
     * called in the add_edit_ingredient. Provides editText boxes for user to
     * include all data to create a new object ingredient and add it to the firestore.
     * @param ingredient
     */
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

    /**
     * Allows user to edit information previously saved in an ingredient object.
     * @param ingredient
     */
    public static void editIngredient(Ingredient ingredient) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Ingredient").document(ingredient.id).update(
                "name", ingredient.name,
                "Cold", ingredient.cold,
                "location", ingredient.location,
                "price", ingredient.price,
                "store", ingredient.store);
    }

    /**
     * In the ingredient list activity, select ingredient to edit or delete. Select delete.
     * Deletes ingredient object from the firestore.
     * @param ingredient
     */
    public static void deleteIngredient(Ingredient ingredient) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Ingredient").document(ingredient.id).delete();
    }

    /**
     * Retrieves all ingredient objects from firestore to call into the oncreate method.
     * When user opens add new ingredient, a listview of all the ingredients in firestore
     * becomes available. User can select ingredients and add it to the new recipe.
     * @param activity
     */
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

    /**
     * In the ingredient activity, this method is called in oncreate to populate the listview with
     * the ingredients from the firestore.
     * @param ingredAct
     */
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

    /**
     * Creates a new Recipe object to add to firestore.
     * @param recipe
     */
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

    /**
     * Currently, not being called. This will allow user to click on an
     * existing recipe and will see what ingredient objects are in the recipe.
     * When clicked, user can add or delete ingredients to the selected recipe.
     * @param recipe
     */
    public static void editRecipe(Recipe recipe) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Recipe").document(recipe.id).update(
                "name", recipe.name,
                "Side", recipe.side
                //"Ingredients", recipe.ingredients
        );
    }

    /**
     * allows user to delete recipe from firestore.
     * @param recipe
     */
    public static void deleteRecipe(Recipe recipe) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Recipe").document(recipe.id).delete();
    }

    /**
     * Within the recipe activity, this is called in oncreate to set up the list view
     * to display all of the recipe objects.
     * @param recAct
     */
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

    /**
     * Inside the menu activity, this method has the user select from the list view on the left
     * to add that recipe onto the Menu. After it is selected, the recipe object will be moved
     * to the list view on the right.
     * @param recipe
     */
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

    /**
     * Deletes a recipe from the menu collection from firestore.
     * @param recipe
     */
    public static void deleteMenuItem(Recipe recipe) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Menu").document(recipe.id).delete();
    }

    /**
     * getAllRecipes is called in the setupListview method in the menu activity.
     * this gathers all the recipes from firebase and populates listview. called in oncreate
     * @param menu
     */
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

    /**
     * Inside the menu activity, this method displays which recipes have been added
     * to the menu collection. Synced with firestore. Called in oncreate
     * @param menuActivity
     */
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

    /**
     * Once the menu collection has objects, the ingredients associated with those recipes will
     * display in the shopping list activity.
     * @param shoppingList
     */
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
                            List<Ingredient> ingredients = new ArrayList<>();
                            for (Recipe recipe : recipes) {
                                for (Ingredient ingredient : recipe.ingredients.ingredientList) {
                                    if (!ingredients.contains(ingredient.name)) {
                                        ingredients.add(ingredient);
                                    }
                                }
                            }

                            shoppingList.getShoppingList().clear();
                            shoppingList.getShoppingList().addAll(ingredients);
                            shoppingList.setUpMenuListView();
                            shoppingList.adapter.notifyDataSetChanged();
                        }
                        else {
                            Log.d("JCS", "Error getting documents: ", task.getException());
                        }
                    }
                });
    }
}
