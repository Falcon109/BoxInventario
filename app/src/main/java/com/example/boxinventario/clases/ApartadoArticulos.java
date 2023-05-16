package com.example.boxinventario.clases;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.example.boxinventario.R;
import com.example.boxinventario.adapted.AdaptadorProducto;
import com.example.boxinventario.db.DBHelper;
import com.example.boxinventario.db.DBProductos;

public class ApartadoArticulos extends AppCompatActivity {
    DBHelper DB;
    RecyclerView recyclerView;
    SQLiteDatabase sqLiteDatabase;
    AdaptadorProducto adaptadorProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartado_articulos);

        recyclerView = findViewById(R.id.listacuerpo);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DBProductos dbProductos = new DBProductos(ApartadoArticulos.this);
        adaptadorProducto = new AdaptadorProducto(this, dbProductos.mostrardatos());
        recyclerView.setAdapter(adaptadorProducto);


        DBHelper dbhelper = new DBHelper(ApartadoArticulos.this);
        SQLiteDatabase db = dbhelper.getWritableDatabase();

    }

    public void Crearproducto(View clic) {
        Intent Crearproducto = new Intent(this, CrearProductos.class);
        startActivity(Crearproducto);
    }


}