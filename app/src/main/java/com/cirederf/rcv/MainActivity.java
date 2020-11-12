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

public class MainActivity extends AppCompatActivity implements ClassDialogBoxCustomPourAjouterUnIngredient.AjouteUnIngredientALaListeDeCourses {

    private RecyclerView recyclerViewPourLaListeDeCourses;
    public List<Ingredients> laListeDeCoursesAAfficher = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clickSurLeBoutonQuiOuvreLaBoiteDeDialogue();
        configureRecyclerViewForCourses();

        IngredientsAdapter ingredientsAdapter = new IngredientsAdapter(creationDeLaListeDeCourses());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerViewPourLaListeDeCourses.getContext(),
                LinearLayoutManager.VERTICAL);
        recyclerViewPourLaListeDeCourses.addItemDecoration(dividerItemDecoration);
        recyclerViewPourLaListeDeCourses.setAdapter(ingredientsAdapter);
    }

    private void configureRecyclerViewForCourses (){
        recyclerViewPourLaListeDeCourses = findViewById(R.id.recyclerView_pour_la_liste_ingredients);
        RecyclerView.LayoutManager coursesLayoutManager = new LinearLayoutManager(this);
        recyclerViewPourLaListeDeCourses.setLayoutManager(coursesLayoutManager);
    }

    public List<Ingredients> creationDeLaListeDeCourses() {
        laListeDeCoursesAAfficher.add(new Ingredients("oranges", 4));
        laListeDeCoursesAAfficher.add(new Ingredients("poires", 4));
        laListeDeCoursesAAfficher.add(new Ingredients("pommes", 2));
        laListeDeCoursesAAfficher.add(new Ingredients("paquets de chips", 12));
        laListeDeCoursesAAfficher.add(new Ingredients("pots de confiture", 4));
        laListeDeCoursesAAfficher.add(new Ingredients("lettres", 14));
        laListeDeCoursesAAfficher.add(new Ingredients("pizzas", 5));
        laListeDeCoursesAAfficher.add(new Ingredients("bananes", 55));
        laListeDeCoursesAAfficher.add(new Ingredients("noix de coco", 1));
        return laListeDeCoursesAAfficher;
    }

    public void clickSurLeBoutonQuiOuvreLaBoiteDeDialogue(){
        FloatingActionButton boutonQuiOuvreLaBoiteDeDialogue = findViewById(R.id.boutonQuiOuvreLaBoiteDeDialogue);
        boutonQuiOuvreLaBoiteDeDialogue.setOnClickListener(v-> {
            //step 3: create the xml for the dialog box (add_an_item_dialog)
            //step 11 : declare and initialise the dialogBox
            ClassDialogBoxCustomPourAjouterUnIngredient classDialogBoxCustomPourAjouterUnIngredient = new ClassDialogBoxCustomPourAjouterUnIngredient();
            classDialogBoxCustomPourAjouterUnIngredient.show(getSupportFragmentManager(), "dialogbox");
        });
    }

    @Override
    public void ajouteUnIngredientALaListeDeCourses(String ajouteLeNom, int quantiteEnInt) {
        Ingredients ingredients = new Ingredients(ajouteLeNom, quantiteEnInt);
        laListeDeCoursesAAfficher.add(ingredients);
    }
}