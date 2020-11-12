package com.cirederf.rcv;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

/**
 * First step in this new advance: adding a button for adding new item
 * Go in the xml containing the recyclerView
 */
//step2: once xml create, declare the  button and give it a value in the method which listen the click

public class MainActivity extends AppCompatActivity implements AddAnItemInTheListDeCoursesDialogBox.AddAnIngredientInListeDeCourse{

    private RecyclerView recyclerViewForCourses;
    public List<Ingredients> listeDeCourses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    public List<Ingredients> createListeDeCourses() {
        listeDeCourses.add(new Ingredients("oranges", 4));
        listeDeCourses.add(new Ingredients("poires", 4));
        listeDeCourses.add(new Ingredients("pommes", 2));
        listeDeCourses.add(new Ingredients("paquets de chips", 12));
        listeDeCourses.add(new Ingredients("pots de confiture", 4));
        listeDeCourses.add(new Ingredients("lettres", 14));
        listeDeCourses.add(new Ingredients("pizzas", 5));
        listeDeCourses.add(new Ingredients("bananes", 55));
        listeDeCourses.add(new Ingredients("noix de coco", 1));
        return listeDeCourses;
    }

    public void clickOnOpenAddAnItemInListeDeCoursesDialogButton(){
        FloatingActionButton openAddAnItemInListeDeCoursesDialog = findViewById(R.id.openAddAnItemInListeDeCoursesDialog);
        openAddAnItemInListeDeCoursesDialog.setOnClickListener(v-> {
            //step 3: create the xml for the dialog box (add_an_item_dialog)
            //step 11 : declare and initialise the dialogBox
            AddAnItemInTheListDeCoursesDialogBox addAnItemInTheListDeCoursesDialogBox = new AddAnItemInTheListDeCoursesDialogBox();
            addAnItemInTheListDeCoursesDialogBox.show(getSupportFragmentManager(), "dialogbox");
        });
    }

    @Override
    public void applyIngredient(String setName, int setQuantityToInt) {
        Ingredients ingredients = new Ingredients(setName, setQuantityToInt);
        listeDeCourses.add(ingredients);
    }
}