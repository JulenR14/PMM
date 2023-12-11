package com.example.repasoexamen_1pmdm;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.transition.Visibility;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.repasoexamen_1pmdm.databinding.FragmentItemAleatorioBinding;
import com.example.repasoexamen_1pmdm.items.Item;
import com.example.repasoexamen_1pmdm.items.ModelItems;
import com.example.repasoexamen_1pmdm.items.ViewModelItems;
import com.example.repasoexamen_1pmdm.items.mostrarItem;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ItemAleatorio#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ItemAleatorio extends Fragment {
    private FragmentItemAleatorioBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentItemAleatorioBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ModelItems modelItems = new ModelItems();
        List<Item> listaItems = modelItems.getListaItems();

        int numeroAleatorio = (int) (Math.random() * listaItems.size());

        Item itemAleatorio = listaItems.get(numeroAleatorio);

        binding.nameItem.setText(itemAleatorio.getNombre());
        binding.nombreCategoria.setText(itemAleatorio.getCategoria());
        binding.cantidadCoste.setText(String.valueOf(itemAleatorio.getPrecio()));
        binding.efectos.setText(itemAleatorio.getEfectos());

    }
}