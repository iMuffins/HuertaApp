package com.huertaUrbana.finalfinalfinalhuerta.ui.agregar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.huertaUrbana.finalfinalfinalhuerta.R;

public class agregarFragment extends Fragment{


    TextView nombre, fecha;

    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_agregar, container, false);








        return root;
    }

    /*public void btGuardarAgregar(View view){
        //setContentView(R.layout.activity_main);
        nombre = (EditText) findViewById(R.id.txNombre);
        fecha = (EditText) findViewById(R.id.txFecha);

    }*/
}