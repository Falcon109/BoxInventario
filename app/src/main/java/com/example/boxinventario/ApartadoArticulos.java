package com.example.boxinventario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;

import com.example.boxinventario.adapted.AdaptadorProducto;
import com.example.boxinventario.entidades.Producto;
import com.example.boxinventario.entidades.Usuario;

import java.io.Serializable;
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

    //new date
    public void init(){
        elementos = new ArrayList<>();
        elementos.add(new Producto("#775447","Galletas", "12-23-31", "4", "1200", "jumbo","Cofis"));
        elementos.add(new Producto("#775447","Bebidas", "12-23-31", "2", "2000", "jumbo","Gaseosas"));
        elementos.add(new Producto("#775447","Papas", "12-23-31", "3", "1800", "jumbo","Cofis"));
        elementos.add(new Producto("#775447","Carne", "12-23-31", "4", "5600", "jumbo","Canes"));
        elementos.add(new Producto("#775447","Jugos", "12-23-31", "6", "2100", "jumbo","Liquidos"));
        elementos.add(new Producto("#775447","Mayonesa", "12-23-31", "2", "3200", "jumbo","Agregados"));
        elementos.add(new Producto("#775447","Confort", "12-23-31", "16", "12000", "jumbo","Otros"));

        AdaptadorProducto adaptadorProducto = new AdaptadorProducto(elementos, this, new AdaptadorProducto.OnItemClickListener(){
            @Override
            public void onItemClick(Producto item) {
                moveToDescription(item);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.listacuerpo);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptadorProducto);


    }
    public void moveToDescription(Producto item) {
        Intent intent = new Intent(this, DescipcionProductos.class);
        intent.putExtra("Producto", (Parcelable) item);
        startActivity(intent);
    }


}