package com.example.examenfinal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.examenfinal.databinding.FragmentItemListRecylerBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ItemListRecylerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ItemListRecylerFragment extends Fragment {

   /* private FragmentItemListRecylerBinding binding;
    //private ViewModelItems itemsViewModel;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentItemListRecylerBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        itemsViewModel = new ViewModelProvider(requireActivity()).get(ViewModelItems.class);
        navController = Navigation.findNavController(view);

        ItemAdapter itemAdapter = new ItemAdapter();

        RecyclerView recyclerView = binding.recyclerViewMovimientos;
        recyclerView.setAdapter(itemAdapter);

        binding.recyclerViewMovimientos.setAdapter(itemAdapter);

        itemsViewModel.obtener().observe(getViewLifecycleOwner(), new Observer<List<Item>>() {
            @Override
            public void onChanged(List<Item> items) {
                itemAdapter.establecerLista(items);
            }
        });


    }

    class ItemAdapter extends RecyclerView.Adapter<ViewHolderMovimiento> {

        List<Item> items;

        @NonNull
        @Override
        public ViewHolderMovimiento onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolderMovimiento(ViewholderItemBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolderMovimiento holder, int position) {
            Item item = items.get(position);

            holder.binding.nombreItem.setText(item.getNombre());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemsViewModel.seleccionar(item);
                    navController.navigate(R.id.mostrarItem);
                }
            });
        }

        @Override
        public int getItemCount() {
            return items != null ? items.size() : 0;
        }

        void establecerLista(List<Item> items){
            this.items = items;
            notifyDataSetChanged();
        }
    }

    class ViewHolderMovimiento extends RecyclerView.ViewHolder {
        ViewholderItemBinding binding;
        public ViewHolderMovimiento(ViewholderItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }*/
}