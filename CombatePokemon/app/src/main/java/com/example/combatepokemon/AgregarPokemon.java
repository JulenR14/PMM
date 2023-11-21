package com.example.combatepokemon;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

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
public class AgregarPokemon extends Fragment {

    private FragmentAgregarPokemonBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentAgregarPokemonBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //boton para agregar pokemon en el fragmento agregar pokemon
        binding.agregarPokemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creamos el pokemon con los datos introducidos
                Pokemon pokemon = new Pokemon(
                        binding.nombre.getText().toString(),
                        Integer.parseInt(binding.hp.getText().toString()),
                        Integer.parseInt(binding.ataque.getText().toString()),
                        Integer.parseInt(binding.defensa.getText().toString()),
                        Integer.parseInt(binding.ataqueEspecial.getText().toString()),
                        Integer.parseInt(binding.defensaEspecial.getText().toString())
                );
                //llamamos a un metodo que nos limpiara los campos
                limpiarParametros();

                //cuando llamamos al metodo agregarPokemon de la clase Combatir, nos devuelve un mensaje
                //este mensaje nos da informacion sobre la creacion del nuevo pokemon
                String mensaje =  Combatir.instance.agregarPokemon(pokemon);

                //mostramos un mensaje mostrando que pokemon se ha creado, o si no se ha podido crear
                Toast.makeText(getContext(), mensaje, Toast.LENGTH_SHORT).show();
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