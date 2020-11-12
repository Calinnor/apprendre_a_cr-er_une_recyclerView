package com.cirederf.rcv;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import java.util.Objects;

// step 5: extend class with dialogFragment
public class ClassDialogBoxCustomPourAjouterUnIngredient extends DialogFragment {

    private EditText ajouteLeNom;
    private EditText ajouteLaQuantiteEnString;
    private AjouteUnIngredientALaListeDeCourses listerner;

    //step 6 :create the method onCreateDialog which will be override
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(getContext()));
        //step 7:inflate the layout linked with this class
        LayoutInflater inflater = Objects.requireNonNull(getActivity()).getLayoutInflater();
        View view = inflater.inflate(R.layout.add_an_item_dialog, null);
        //step 8: give values to the dialogBox.
        builder.setView(view).setTitle("Entrez un nom (Mot) et sa quantité (chiffre ou nombre)")
                //When setting the negative button, override onClick is automaticaly implemented
                .setNegativeButton("Annuler", (dialogInterface, i) -> {
                //When setting the positive button, override onClick is automaticaly implemented
                }).setPositiveButton("Enregistrer", (dialogInterface, i) -> {
                    String ajouteNom = ajouteLeNom.getText().toString();
                    int quantiteEnInt = Integer.parseInt(ajouteLaQuantiteEnString.getText().toString());
                    listerner.ajouteUnIngredientALaListeDeCourses(ajouteNom, quantiteEnInt);
                });
        ajouteLeNom = view.findViewById(R.id.entrer_un_nom_pour_ingredient);
        ajouteLaQuantiteEnString = view.findViewById(R.id.entrer_une_quantite_pour_ingredient);
        //step 9 :declare and implement values for set name and quantities
        return builder.create();
        //step 10 : the dialogBox is ready to use. Go in main in the method which will call it when we click on the button
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listerner = (AjouteUnIngredientALaListeDeCourses) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "AjouteUnIngredientALaListeDeCourses doit etre implementée");
        }
    }

    public interface AjouteUnIngredientALaListeDeCourses {
        void ajouteUnIngredientALaListeDeCourses(String ajouteLeNom, int quantiteEnInt);
    }






}
