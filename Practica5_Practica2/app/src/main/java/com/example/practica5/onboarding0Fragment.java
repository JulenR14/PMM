package com.example.practica5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link onboarding0Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class onboarding0Fragment extends Fragment {

    Button botonSiguiente;
    Button skip;

    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_onboarding0, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        botonSiguiente = view.findViewById(R.id.botonSiguiente);
        skip = view.findViewById(R.id.botonSkip);

        botonSiguiente.setOnClickListener(view1 -> navController.navigate(R.id.action_onboarding0Fragment_to_onboarding1Fragment));
        skip.setOnClickListener(view1 -> navController.navigate(R.id.action_onboarding0Fragment_to_homeFragment));
    }
}