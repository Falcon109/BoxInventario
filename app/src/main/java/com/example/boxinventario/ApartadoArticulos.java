package com.example.boxinventario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.boxinventario.adapted.AdaptadorProducto;
import com.example.boxinventario.entidades.Producto;
import com.example.boxinventario.entidades.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApartadoArticulos extends AppCompatActivity {

    List<Producto> elementos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartado_articulos);

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
        elementos.add(new Producto("#775447","Galletas", new Date(), "4", "1200", "jumbo","Cofis"));
        elementos.add(new Producto("#775447","Bebidas", new Date(), "2", "2000", "jumbo","Gaseosas"));
        elementos.add(new Producto("#775447","Papas", new Date(), "3", "1800", "jumbo","Cofis"));
        elementos.add(new Producto("#775447","Carne", new Date(), "4", "5600", "jumbo","Canes"));
        elementos.add(new Producto("#775447","Jugos", new Date(), "6", "2100", "jumbo","Liquidos"));
        elementos.add(new Producto("#775447","Mayonesa", new Date(), "2", "3200", "jumbo","Agregados"));
        elementos.add(new Producto("#775447","Confort", new Date(), "16", "12000", "jumbo","Otros"));

        AdaptadorProducto adaptadorProducto = new AdaptadorProducto(elementos, this);
        RecyclerView recyclerView = findViewById(R.id.listacuerpo);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptadorProducto);

    }

}