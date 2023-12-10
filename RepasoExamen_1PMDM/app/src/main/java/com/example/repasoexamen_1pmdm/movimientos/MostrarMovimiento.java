package com.example.repasoexamen_1pmdm.movimientos;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.repasoexamen_1pmdm.R;
import com.example.repasoexamen_1pmdm.databinding.FragmentMostrarMovimientoBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MostrarMovimiento#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MostrarMovimiento extends Fragment {

    FragmentMostrarMovimientoBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentMostrarMovimientoBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewModelMovimientos movimientosViewModel = new ViewModelProvider(requireActivity()).get(ViewModelMovimientos.class);

        movimientosViewModel.seleccionado().observe(getViewLifecycleOwner(), new Observer<Movimiento>() {
            @Override
            public void onChanged(Movimiento movimiento) {
                binding.nameMovement.setText(movimiento.getNombre());
                binding.cantidadAccuary.setText(String.valueOf(movimiento.getAccuracy()));
                String todosPokemons = "";
                for (String pokenon : movimiento.getPokemons()) {
                    todosPokemons += pokenon + " ";
                }
                binding.todosPokemons.setText(todosPokemons);
            }
        });
    }
}