package com.cirederf.rcv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

/**
 * First step in this new advance: adding a button for adding new item
 * Go in the xml containing the recyclerView
 */
public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewForCourses;
    //step2: once xml create, declare the  button
    private FloatingActionButton openAddAnItemInListeDeCoursesDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        openAddAnItemInListeDeCoursesDialog = findViewById(R.id.openAddAnItemInListeDeCoursesDialog);
        clickOnOpenAddAnItemInListeDeCoursesDialogButton();
        configureRecyclerViewForCourses();

        IngredientsAdapter ingredientsAdapter = new IngredientsAdapter(createListeDeCourses());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerViewForCourses.getContext(),
                LinearLayoutManager.VERTICAL);
        recyclerViewForCourses.addItemDecoration(dividerItemDecoration);
        recyclerViewForCourses.setAdapter(ingredientsAdapter);
    }

    private void configureRecyclerViewForCourses (){
        recyclerViewForCourses = findViewById(R.id.recyclerView_for_ingredients);
        RecyclerView.LayoutManager coursesLayoutManager = new LinearLayoutManager(this);
        recyclerViewForCourses.setLayoutManager(coursesLayoutManager);
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

    public void clickOnOpenAddAnItemInListeDeCoursesDialogButton(){
        openAddAnItemInListeDeCoursesDialog = findViewById(R.id.openAddAnItemInListeDeCoursesDialog);
        openAddAnItemInListeDeCoursesDialog.setOnClickListener(v-> {
            AddAnItemDialog addAnItemDialog = new AddAnItemDialog();
            addAnItemDialog.show(getSupportFragmentManager(), "test");
        });
    }


}