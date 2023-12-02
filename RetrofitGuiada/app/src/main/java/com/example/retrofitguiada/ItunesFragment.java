package com.example.retrofitguiada;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.retrofitguiada.databinding.FragmentItunesBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ItunesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ItunesFragment extends Fragment {

    FragmentItunesBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentItunesBinding.inflate(inflater, container, false)).getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ItunesViewModel itunesViewModel = new ViewModelProvider(this).get(ItunesViewModel.class);

        binding.texto.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                itunesViewModel.buscar(newText);
                return false;
            }
        });

        itunesViewModel.respuestaMutableLiveData.observe(getViewLifecycleOwner(),new Observer<Itunes.Respuesta>() {
            @Override
            public void onChanged(Itunes.Respuesta respuesta) {
                respuesta.resultados.forEach(contenido -> Log.e("ABCD", contenido.artistName + ", " + contenido.trackName + ", " + contenido.artworkUrl100));
            }
        });
    }
}