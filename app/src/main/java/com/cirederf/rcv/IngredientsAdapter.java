package com.cirederf.rcv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//step 11 recyclerview: class for recyclerview adapter is created
//step 17 recyclerview may doing class extends with recyclerview.adapter
//step 18 recyclerview in <> after class extends may pas the name of the innerclass
//step 19 recyclerview: red line is now under the name of the class: may now automaticaly implement some methods ;): oncreate, onBind, getItemCount go to step 20 now
public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsAdapter.IngredientsViewHolder>{

    //step 20 recyclerview may now create a constructor. This one need for value the list of object which be display
    //step 20: here the list is a list of...ingredients. May first declare the list...;)
    List<Ingredients> listIngredients;
    //go to step 21 recyclerview below the static class

    //step 12 recyclerview : create a innerclass wich herits of viewholder
    //this class will stock datas from one item ingredient (name and quantite) with point on  xml id name and id quantite

    //step 13 recyclerview : when class is create there's an red line under the name...it's normal: need to create a constructor...
    public static class IngredientsViewHolder extends RecyclerView.ViewHolder {


        //step 15 recyclerview : declare the references for the xml value
        TextView name;
        TextView quantity;
        //go to step 16 in constructor

        //step 14 recyclerview once constructor create may create reference on ingredient name and ingredient quantity go to step 15 just ahead
        public IngredientsViewHolder(@NonNull View /*itemView this base name is the */ linearLayoutFromAdapterForCoursesXml) {
            super(linearLayoutFromAdapterForCoursesXml);
            //step 16 recyclerview : initialise the xml references
            name = linearLayoutFromAdapterForCoursesXml.findViewById(R.id.ingredient_name);
            quantity = linearLayoutFromAdapterForCoursesXml.findViewById(R.id.ingredient_quantity);
            //step 17 recyclerview : view holder is ready, go to configure adapter...do now makes IngredientsAdapter class extends with...
        }
    }

    //step 21 recyclerview : create a constructor
    public IngredientsAdapter(List<Ingredients> listIngredients) {
        this.listIngredients = listIngredients;
    }
    //step 22 recyclerview : now implemente getitemcount

    @NonNull
    @Override
    //step 23 recyclerview : may pass a view for argument. This view is the layout to be display (adapter_courses.xml)
    public IngredientsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //step 24 recyclerview: create the view to be passed
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_for_courses, parent, false);
        //step 25 recyclerview : may now create an instance of the viewholder with the view created just before in argument
        IngredientsViewHolder ingredientsViewHolder = new IngredientsViewHolder(view);
        //step 26 recyclerview: may now return this viewholder
        return ingredientsViewHolder;
    }

    //step 27 recyclerview : may now make the link between datas in the list and the viewholder
    @Override
    public void onBindViewHolder(@NonNull IngredientsViewHolder holder, int position) {
        //step 28 recyclerview: the iten to be display is an ingredient and is in position in the list
        Ingredients ingredients = listIngredients.get(position);
        //step 29 recyclerview: may now pass the name and quantity. Ingredientsviewholder is passed in holder, so...
        //we pass the text getting from ingredient (meaning at the display position in the list)
        holder.name.setText(ingredients.getName()); //this one set a String
        holder.quantity.setText(String.valueOf(ingredients.getQuantity())); //this one set an int in a String
        //step 30 recyclerview: go to main for the last things to do
    }

    //step 22 recyclerview: add the size to return
    @Override
    public int getItemCount() {
        return listIngredients.size();
    }
    //step 23 recyclerview go to oncreateviewholder

}
