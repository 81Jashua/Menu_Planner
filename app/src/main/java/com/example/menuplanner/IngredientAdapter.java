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
import java.util.List;

public class IngredientAdapter  extends ArrayAdapter<Ingredient> {
    private List<Ingredient> ingredientList;

    public IngredientAdapter(@NonNull Context context, int resource, List<Ingredient> ingredientList) {
        super(context, resource);
        this.ingredientList = ingredientList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Ingredient ingredient = getItem(position);
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1,
                    parent, false);
        }

        TextView ingredientText = convertView.findViewById(R.id.textViewName);

        ingredientText.setText(ingredient.name);

        return convertView;
    }
}
