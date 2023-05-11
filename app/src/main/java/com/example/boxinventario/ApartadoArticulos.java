package com.example.boxinventario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Toast;

import com.example.boxinventario.adapted.AdaptadorProducto;
import com.example.boxinventario.db.DBHelper;
import com.example.boxinventario.db.DBProductos;
import com.example.boxinventario.entidades.Producto;

import java.util.ArrayList;
import java.util.List;

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

        if(db != null){
            Toast.makeText(this, "Lista de Compra", Toast.LENGTH_SHORT).show();
        }else Toast.makeText(this, "Error al cargar la Lista de Compra", Toast.LENGTH_SHORT).show();

    }

    public void Crearproducto(View clic) {
        Intent Crearproducto = new Intent(this, CrearProductos.class);
        startActivity(Crearproducto);
    }


}