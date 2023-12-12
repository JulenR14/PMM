package com.example.examenfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;

import com.example.examenfinal.databinding.ActivityMainBinding;
import com.example.examenfinal.models.MoveListItem;
import com.example.examenfinal.pokeapi.PokeAPI;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //declaramos el binding para poder conectarlo con el layout
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //instanciamos el binging inflando el layout
        setContentView((binding = ActivityMainBinding.inflate(getLayoutInflater())).getRoot());

        //creamos un mutablelivedata para poder obtener la lista de movimientos de la API
        MutableLiveData<List<MoveListItem>> moveList = new MutableLiveData<>();
        PokeAPI.getMoveList(moveList);

        //con el setSupportActionBar le decimos que use la toolbar como actionbar
        setSupportActionBar(binding.toolbar);

        //creamos un objeto de tipo AppBarConfiguration para poder configurar la toolbar
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.moveListRecyclerFragment, R.id.itemListRecylerFragment
        ).setOpenableLayout(binding.drawerLayout).build();

        //instanciamos el navController para poder navegar entre fragments
        NavController navController = ((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment)).getNavController();
        NavigationUI.setupWithNavController(binding.navView, navController);
        NavigationUI.setupWithNavController(binding.toolbar, navController, appBarConfiguration);

    }
}