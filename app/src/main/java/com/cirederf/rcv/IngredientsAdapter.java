package com.cirederf.rcv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsAdapter.IngredientsViewHolder>{

    List<Ingredients> listIngredients;

    public static class IngredientsViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView quantity;

        public IngredientsViewHolder(@NonNull View linearLayoutFromAdapterForCoursesXml) {
            super(linearLayoutFromAdapterForCoursesXml);
            name = linearLayoutFromAdapterForCoursesXml.findViewById(R.id.ingredient_name);
            quantity = linearLayoutFromAdapterForCoursesXml.findViewById(R.id.ingredient_quantity);
        }
    }

    public IngredientsAdapter(List<Ingredients> listIngredients) {
        this.listIngredients = listIngredients;
    }

    @NonNull
    @Override
    public IngredientsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_for_courses, parent, false);
        return new IngredientsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientsViewHolder holder, int position) {
        Ingredients ingredients = listIngredients.get(position);
        holder.name.setText(ingredients.getName());
        holder.quantity.setText(String.valueOf(ingredients.getQuantity()));
    }

    @Override
    public int getItemCount() {
        return listIngredients.size();
    }

}
