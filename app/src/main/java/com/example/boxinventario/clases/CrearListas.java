package com.example.boxinventario.clases;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.boxinventario.R;
import com.example.boxinventario.adapted.AdaptadorProducto;
import com.example.boxinventario.entidades.Producto;

import java.util.ArrayList;

public class CrearListas extends AppCompatActivity {

    private ArrayList<Producto> productosSeleccionados = new ArrayList<>();
    private AdaptadorProducto adaptadorProducto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_listas);



    }
}