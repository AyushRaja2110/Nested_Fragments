package com.example.fragments1.ui.home;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fragments1.R;
import com.google.android.material.snackbar.Snackbar;

public class Tab1Fragment extends Fragment{

    EditText name,pass;
    com.google.android.material.button.MaterialButton submit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.fragment_tab1, container, false);

        name = v.findViewById(R.id.name);
        pass = v.findViewById(R.id.pass);
        submit = v.findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String na = name.getText().toString();
                String ps = pass.getText().toString();

                if (na.equals("") || ps.equals(""))
                {
                    Toast.makeText(getContext(), "Fields Are Empty", Toast.LENGTH_SHORT).show();
                }
                else if (name.getText().toString().equals("ayush") || pass.getText().toString().equals("2110"))
                {
                    //Toast.makeText(getContext(), "Successfully", Toast.LENGTH_SHORT).show();
                    showSnakBarsuccess();
                }
                else
                {
                    Toast.makeText(getContext(), "Error...", Toast.LENGTH_SHORT).show();
                    showSnakBarerror();
                }
            }
        });

        return v;

    }

    private void showSnakBarerror() {
        Snackbar snackbar = Snackbar.make(getActivity().findViewById(android.R.id.content), "Error", Snackbar.LENGTH_LONG);
        View custom_view = getLayoutInflater().inflate(R.layout.item_snackbar_error,null);

        snackbar.getView().setBackgroundColor(Color.TRANSPARENT);
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbar.getView();
        snackbarLayout.setPadding(0,0,0,0);
//        snackbar.getAnimationMode();
//        snackbar.getDuration();
//        snackbar.isShown();
//        snackbar.setActionTextColor(Color.RED);
        snackbarLayout.addView(custom_view,0);
        snackbar.show();
    }

    private void showSnakBarsuccess() {

     Snackbar snackbar = Snackbar.make(getActivity().findViewById(android.R.id.content), "Success", Snackbar.LENGTH_LONG);
     View custom_view = getLayoutInflater().inflate(R.layout.item_snackbar_success,null);

     snackbar.getView().setBackgroundColor(Color.TRANSPARENT);
     Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbar.getView();
     snackbarLayout.setPadding(0,0,0,0);
     snackbarLayout.addView(custom_view,0);
     snackbar.show();
    }
}