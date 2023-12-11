package com.example.repasoexamen_1pmdm.items;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.repasoexamen_1pmdm.R;
import com.example.repasoexamen_1pmdm.databinding.FragmentMostrarItemBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link mostrarItem#newInstance} factory method to
 * create an instance of this fragment.
 */
public class mostrarItem extends Fragment {

    private FragmentMostrarItemBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentMostrarItemBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewModelItems itemsViewModel = new ViewModelProvider(requireActivity()).get(ViewModelItems.class);

        itemsViewModel.seleccionado().observe(getViewLifecycleOwner(), new Observer<Item>() {
            @Override
            public void onChanged(Item item) {
                binding.nameItem.setText(item.getNombre());
                binding.nombreCategoria.setText(String.valueOf(item.getCategoria()));
                binding.cantidadCoste.setText(String.valueOf(item.getPrecio()));
                binding.efectos.setText(item.getEfectos());
            }
        });
    }
}