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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// step 5: extend class with dialogFragment
public class AddAnItemInTheListDeCoursesDialogBox extends DialogFragment {

    private EditText setTheName;
    private EditText setTheQuantity;
    private AddAnIngredientInListeDeCourse listerner;

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
                    String setName = setTheName.getText().toString();
                    //String setQuantity = setTheQuantity.getText().toString();
                    int setQuantityToInt = Integer.parseInt(/*setQuantity*/setTheQuantity.getText().toString());
                    listerner.applyIngredient(setName, setQuantityToInt);
                });
        setTheName = view.findViewById(R.id.editName);
        setTheQuantity = view.findViewById(R.id.editQuantity);
        //step 9 :declare and implement values for set name and quantities
        return builder.create();
        //step 10 : the dialogBox is ready to use. Go in main in the method which will call it when we click on the button
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listerner = (AddAnIngredientInListeDeCourse) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "AddAnIngredientInListeDeCourse doit etre implementée");
        }
    }

    public interface AddAnIngredientInListeDeCourse{
        void applyIngredient(String setName, int setQuantityToInt);
    }






}
