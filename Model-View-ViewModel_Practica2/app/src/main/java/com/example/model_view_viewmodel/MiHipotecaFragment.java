package com.example.model_view_viewmodel;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.model_view_viewmodel.databinding.FragmentMiHipotecaBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MiHipotecaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MiHipotecaFragment extends Fragment {

    //atributos
    private FragmentMiHipotecaBinding binding;
    private boolean mostrarInfo = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentMiHipotecaBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final MiHipotecaViewModel miHipotecaViewModel = new ViewModelProvider(this).get(MiHipotecaViewModel.class);

        //manejamos el evento cuando clicken a Calcular
        binding.calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //recogemos los datos
                double capital = Double.parseDouble(binding.capital.getText().toString());
                int plazo = Integer.parseInt(binding.plazo.getText().toString());
                String nombre = binding.nombreUsuario.getText().toString();
                String apellido = binding.apellidoUsuario.getText().toString();
                int edad = Integer.parseInt(binding.edadUsuario.getText().toString());

                //llamamos al metodo calcular del viewmodel
                miHipotecaViewModel.calcular(capital, plazo, edad, nombre, apellido);
            }
        });

        //observamos los cambios en el viewmodel
        miHipotecaViewModel.cuota.observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double cuota) {
                binding.cuota.setText(String.format("%.2f",cuota));
            }
        });

        //observamos los cambios en el viewmodel
        miHipotecaViewModel.datosUsuario.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String informacion) {
                binding.datosUsuario.setText(informacion);
            }
        });

        miHipotecaViewModel.errorCapital.observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double capitalMinimo) {
                //si el capital es inferior al minimo, mostramos el error
                if (capitalMinimo != null) {
                    binding.capital.setError("El capital no puede ser inferor a " + capitalMinimo + " euros");
                    binding.cuota.setVisibility(View.GONE);
                    binding.datosUsuario.setVisibility(View.GONE);
                    mostrarInfo = false;
                } else {
                    binding.capital.setError(null);
                    mostrarInfo = true;
                }
            }
        });

        miHipotecaViewModel.errorPlazos.observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer plazoMinimo) {
                //si el plazo es inferior al minimo, mostramos el error
                if (plazoMinimo != null) {
                    binding.plazo.setError("El plazo no puede ser inferior a " + plazoMinimo + " años");
                    binding.cuota.setVisibility(View.GONE);
                    binding.datosUsuario.setVisibility(View.GONE);
                    mostrarInfo = false;
                } else {
                    binding.plazo.setError(null);
                    mostrarInfo = true;
                }
            }
        });

        miHipotecaViewModel.errorEdad.observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer edadMinima) {
                //si la edad es inferior al minimo, mostramos el error
                if (edadMinima != null){
                    binding.edadUsuario.setError("La edad no puede ser inferior a " + edadMinima + " años");
                    binding.cuota.setVisibility(View.GONE);
                    binding.datosUsuario.setVisibility(View.GONE);
                    mostrarInfo = false;
                }else{
                    binding.edadUsuario.setError(null);
                    mostrarInfo = true;
                }
            }
        });

        miHipotecaViewModel.calculando.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean calculando) {
                if (calculando) {
                    //si esta calculando, mostramos el mensaje
                    binding.calculando.setVisibility(View.VISIBLE);
                    binding.cuota.setVisibility(View.GONE);
                    binding.datosUsuario.setVisibility(View.GONE);
                } else {
                    binding.calculando.setVisibility(View.GONE);
                    if (mostrarInfo){
                        binding.cuota.setVisibility(View.VISIBLE);
                        binding.datosUsuario.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
    }
}