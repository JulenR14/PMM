package com.example.combatepokemon;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.combatepokemon.databinding.FragmentAgregarPokemonBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link agregarPokemon#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AgregarPokemonFragment extends Fragment {

    private FragmentAgregarPokemonBinding binding;
    private Pokemon pokemonAgregar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentAgregarPokemonBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(view);


        final PokemonViewModel pokemonViewModel = new ViewModelProvider(this).get(PokemonViewModel.class);

        //boton para agregar pokemon en el fragmento agregar pokemon
        binding.crearPokemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean error = false;

                if(binding.nombre.getText().toString().equals("")){
                    error = true;
                    binding.nombre.setError("El nombre no puede estar vacio");
                }
                try {
                    Integer.parseInt(binding.hp.getText().toString());
                }catch (Exception e){
                    error = true;
                    binding.hp.setError("La vida debe ser un numero");
                }
                try{
                    Integer.parseInt(binding.ataque.getText().toString());
                }catch (Exception e){
                    error = true;
                    binding.ataque.setError("El ataque debe ser un numero");
                }
                try {
                    Integer.parseInt(binding.defensa.getText().toString());
                }catch (Exception e){
                    error = true;
                    binding.defensa.setError("La defensa debe ser un numero");
                }
                try{
                    Integer.parseInt(binding.ataqueEspecial.getText().toString());
                }catch (Exception e){
                    error = true;
                    binding.ataqueEspecial.setError("El ataque especial debe ser un numero");
                }
                try {
                    Integer.parseInt(binding.defensaEspecial.getText().toString());
                }catch (Exception e){
                    error = true;
                    binding.defensaEspecial.setError("La defensa especial debe ser un numero");
                }

                if (!error){
                    pokemonViewModel.agregarPokemon(binding.nombre.getText().toString(),
                            Integer.parseInt(binding.hp.getText().toString()),
                            Integer.parseInt(binding.ataque.getText().toString()),
                            Integer.parseInt(binding.defensa.getText().toString()),
                            Integer.parseInt(binding.ataqueEspecial.getText().toString()),
                            Integer.parseInt(binding.defensaEspecial.getText().toString()));

                    limpiarParametros();
                }
            }
        });

        pokemonViewModel.errorNombre.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if(s != null){
                    binding.nombre.setError(s);
                }else{
                    binding.nombre.setError(null);
                }
            }
        });

        pokemonViewModel.errorHp.observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                if(integer != null){
                    binding.hp.setError("La vida debe estar entre 0 y 999");
                }else{
                    binding.hp.setError(null);
                }
            }
        });

        pokemonViewModel.errorAtaque.observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                if(integer != null){
                    binding.ataque.setError("El ataque debe estar entre 0 y 999");
                }else{
                    binding.ataque.setError(null);
                }
            }
        });

        pokemonViewModel.errorDefensa.observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                if(integer != null){
                    binding.defensa.setError("La defensa debe estar entre 0 y 999");
                }else{
                    binding.defensa.setError(null);
                }
            }
        });

        pokemonViewModel.errorAtaqueEspecial.observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                if(integer != null){
                    binding.ataqueEspecial.setError("El ataque especial debe estar entre 0 y 999");
                }else{
                    binding.ataqueEspecial.setError(null);
                }
            }
        });

        pokemonViewModel.errorDefensaEspecial.observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                if(integer != null){
                    binding.defensaEspecial.setError("La defensa especial debe estar entre 0 y 999");
                }else{
                    binding.defensaEspecial.setError(null);
                }
            }
        });

        PokemonViewModel.pokemon1.observe(getViewLifecycleOwner(), new Observer<Pokemon>() {
            @Override
            public void onChanged(Pokemon pokemon) {
                Toast.makeText(getContext(), "Pokemon 1 creado", Toast.LENGTH_SHORT).show();
                binding.informacionPokemon.setText(pokemon.toString());
            }
        });

        PokemonViewModel.pokemon2.observe(getViewLifecycleOwner(), new Observer<Pokemon>() {
            @Override
            public void onChanged(Pokemon pokemon) {
                Toast.makeText(getContext(), "Pokemon 2 creado", Toast.LENGTH_SHORT).show();
                binding.informacionPokemon.setText(pokemon.toString());
            }
        });

        pokemonViewModel.creandoPokemon.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean creando) {
                if (creando){
                    binding.calculando.setVisibility(View.VISIBLE);
                    binding.crearPokemon.setVisibility(View.GONE);
                }else{
                    binding.calculando.setVisibility(View.GONE);
                    binding.crearPokemon.setVisibility(View.VISIBLE);

                }
            }
        });
    }

    //limpiamos los parametros
    public void limpiarParametros(){
        binding.nombre.setText("");
        binding.hp.setText("");
        binding.ataque.setText("");
        binding.defensa.setText("");
        binding.ataqueEspecial.setText("");
        binding.defensaEspecial.setText("");
    }
}