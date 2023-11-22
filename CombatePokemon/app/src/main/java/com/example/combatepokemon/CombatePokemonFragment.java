package com.example.combatepokemon;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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

        if (PokemonViewModel.pokemon1.getValue() != null && PokemonViewModel.pokemon2.getValue() != null){
            PokemonViewModel.pokemon1.observe(getViewLifecycleOwner(), pokemon -> {
                binding.primerPokemon.setText(pokemon.toString());
            });
            pokemonViewModel.pokemon2.observe(getViewLifecycleOwner(), pokemon -> {
                binding.segundoPokemon.setText(pokemon.toString());
            });

            binding.combatir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pokemonViewModel.combatir();
                }
            });

            pokemonViewModel.batallaTerminada.observe(getViewLifecycleOwner(), batallaTerminada -> {
                if (batallaTerminada){
                    Toast.makeText(getContext(), "Batalla terminada", Toast.LENGTH_SHORT).show();
                }
            });

        }else{
            binding.primerPokemon.setVisibility(View.GONE);
            binding.segundoPokemon.setVisibility(View.GONE);
            binding.combatir.setVisibility(View.GONE);
            Toast.makeText(getContext(), "No hay pokemons, vuelve y crealos", Toast.LENGTH_SHORT).show();
        }
    }
}