package com.example.boxinventario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ApartadoLista extends AppCompatActivity {

    List<ListaProducto> elementos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartado_lista);

        init();

    }

    //Metodo para ir a crear Lugares de interes
    public void VolverMenu (View clic7) {
        Intent Volvermenu = new Intent(this, MainActivity.class);
        startActivity(Volvermenu);
    }

    public void IrUsuario(View clic8) {
        Intent IraUsuario = new Intent(this, Usuario.class);
        startActivity(IraUsuario);
    }

    public void init(){
        elementos = new ArrayList<>();
        elementos.add(new ListaProducto("#775447","Papas","4 de abril","2"));
        elementos.add(new ListaProducto("#775447","Bebidas 1lt","4 de abril","2"));
        elementos.add(new ListaProducto("#775447","Galletas","4 de abril","3"));
        elementos.add(new ListaProducto("#775447","Tallarines","1 de abril","7"));
        elementos.add(new ListaProducto("#775447","Arroz","1 de abril","3"));

        ListaAdaptador listaAdaptador = new ListaAdaptador(elementos, this);
        RecyclerView recyclerView = findViewById(R.id.listacuerpo);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listaAdaptador);

    }

}