package com.example.combatepokemon;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.combatepokemon.databinding.FragmentCombatePokemonBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CombatePokemonFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CombatePokemonFragment extends Fragment {

    private FragmentCombatePokemonBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentCombatePokemonBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final PokemonViewModel pokemonViewModel = new ViewModelProvider(this).get(PokemonViewModel.class);

        binding.primerPokemon.setText(pokemonViewModel.pokemon1.getValue().toString());
        binding.segundoPokemon.setText(pokemonViewModel.pokemon2.getValue().toString());

        binding.combatir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}