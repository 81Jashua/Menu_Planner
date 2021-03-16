package com.example.menuplanner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class IngredientAdapter  extends ArrayAdapter<Ingredient> {
    private ArrayList<Ingredient> ingredientList;

    public IngredientAdapter(@NonNull Context context, int resource, ArrayList<Ingredient> ingredientList) {
        super(context, resource);
        this.ingredientList = ingredientList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int phraseIndex = position;
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_ingredients,
                    parent, false);
        }

        TextView ingredientText = convertView.findViewById(R.id.textViewName);

        ingredientText.setText(ingredientList.get(position).getName());

        return super.getView(position, convertView, parent);
    }
}
