package com.example.pmm_fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Onboarding2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Onboarding2Fragment extends Fragment {

    Button botonFinalizar ;
    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_onboarding2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstancesState) {
        super.onViewCreated(view, savedInstancesState);

        navController = Navigation.findNavController(view);

        botonFinalizar = view.findViewById(R.id.botonFinalizar);

        botonFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_onboarding2Fragment_to_homeFragment);
            }
        });

    }

}