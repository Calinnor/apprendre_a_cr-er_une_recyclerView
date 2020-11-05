package com.cirederf.rcv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

/*
First step recyclerView for RcV exercice: create an object class here ingredients
step 2 in ingredients class
Ne pas oublier la dépendance
 */
public class MainActivity extends AppCompatActivity {

    //step 6 recyclerview declare recyclerview
    private RecyclerView recyclerViewForCourses;

    //step 7 recyclerview declare layoutmanager
    //go to step 8 in oncreate: initialise 6/7
    private RecyclerView.LayoutManager coursesLayoutManager;

    //step 30 recyclerview: instancied the adapter
    private IngredientsAdapter ingredientsAdapter;
    //now in create: for initialise it (step31)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //step 9 recyclerview method configuration's call
        configureRecyclerViewForCourses();
        //at this point may add an adapter doing link between recyclerview and data to be display
        //go to step 10 recyclerview: create a layout with only one line: adapter_for_courses

        //step 31 recyclerview: initialise adapter and add divider between every items
        ingredientsAdapter = new IngredientsAdapter(createListeDeCourses());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerViewForCourses.getContext(),
                LinearLayoutManager.VERTICAL);
        recyclerViewForCourses.addItemDecoration(dividerItemDecoration);
        recyclerViewForCourses.setAdapter(ingredientsAdapter);
    }


    //step 8 recyclerview initialising recyclerview and layoutmanager
    private void configureRecyclerViewForCourses (){
        recyclerViewForCourses = findViewById(R.id.recyclerView_for_ingredients);
        coursesLayoutManager = new LinearLayoutManager(this);
        recyclerViewForCourses.setLayoutManager(coursesLayoutManager);
        //go to step 9 recyclerview: call method in main
    }

    private List<Ingredients> createListeDeCourses() {
        List<Ingredients> listCourses = new ArrayList<>();
        listCourses.add(new Ingredients("oranges", 4));
        listCourses.add(new Ingredients("poires", 4));
        listCourses.add(new Ingredients("pommes", 2));
        listCourses.add(new Ingredients("paquets de chips", 12));
        listCourses.add(new Ingredients("pots de confiture", 4));
        listCourses.add(new Ingredients("lettres", 14));
        listCourses.add(new Ingredients("pizzas", 5));
        listCourses.add(new Ingredients("bananes", 55));
        listCourses.add(new Ingredients("noix de coco", 1));
        return listCourses;
    }
}