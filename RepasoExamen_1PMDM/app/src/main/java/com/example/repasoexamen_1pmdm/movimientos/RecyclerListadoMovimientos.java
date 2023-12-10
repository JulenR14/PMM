package com.example.repasoexamen_1pmdm.movimientos;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.repasoexamen_1pmdm.R;
import com.example.repasoexamen_1pmdm.databinding.FragmentListadoMovimientosBinding;
import com.example.repasoexamen_1pmdm.databinding.FragmentMostrarMovimientoBinding;
import com.example.repasoexamen_1pmdm.databinding.ViewholderMovimientoBinding;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecyclerListadoMovimientos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecyclerListadoMovimientos extends Fragment {

    private FragmentListadoMovimientosBinding binding;
    private ViewModelMovimientos movimientosViewModel;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentListadoMovimientosBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        movimientosViewModel = new ViewModelProvider(requireActivity()).get(ViewModelMovimientos.class);
        navController = Navigation.findNavController(view);

        MovimientoAdapter movimientoAdapter = new MovimientoAdapter();

        RecyclerView recyclerView = binding.recyclerViewMovimientos;
        recyclerView.setAdapter(movimientoAdapter);

        binding.recyclerViewMovimientos.setAdapter(movimientoAdapter);

        movimientosViewModel.obtener().observe(getViewLifecycleOwner(), new Observer<List<Movimiento>>() {
            @Override
            public void onChanged(List<Movimiento> movimientos) {
                movimientoAdapter.establecerLista(movimientos);
            }
        });
    }

    class MovimientoAdapter extends RecyclerView.Adapter<MovimientoViewHolder>{

        List<Movimiento> movimientos;

        public Movimiento obtenerElemento(int posicion){
            return movimientos.get(posicion);
        }

        @NonNull
        @Override
        public MovimientoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MovimientoViewHolder(ViewholderMovimientoBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MovimientoViewHolder holder, int position) {
            Movimiento movimiento = movimientos.get(position);

            holder.binding.nombreMovimiento.setText(movimiento.getNombre());

            holder.itemView.setOnClickListener(v -> {
                movimientosViewModel.seleccionar(movimiento);
                navController.navigate(R.id.mostrarMovimiento);
            });
        }

        @Override
        public int getItemCount() {
            return movimientos != null ? movimientos.size() : 0;
        }

        public void establecerLista(List<Movimiento> movimientos){
            this.movimientos = movimientos;
            notifyDataSetChanged();
        }
    }

    class MovimientoViewHolder extends RecyclerView.ViewHolder{

        private final ViewholderMovimientoBinding binding;

        public MovimientoViewHolder(ViewholderMovimientoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}