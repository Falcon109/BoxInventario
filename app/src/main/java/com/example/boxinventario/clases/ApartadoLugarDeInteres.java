package com.example.boxinventario.clases;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.example.boxinventario.CrearLugaresInteres;
import com.example.boxinventario.R;
import com.example.boxinventario.adapted.AdaptadorLugar;
import com.example.boxinventario.adapted.AdaptadorProducto;
import com.example.boxinventario.db.DBHelper;
import com.example.boxinventario.db.DBLugaresInteres;
import com.example.boxinventario.db.DBProductos;

public class ApartadoLugarDeInteres extends AppCompatActivity {
    ;
    RecyclerView recyclerView;
    AdaptadorLugar adaptadorLugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartado_lugar_de_interes);

        recyclerView = findViewById(R.id.listacuerpo);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DBLugaresInteres dbLugaresInteres = new DBLugaresInteres(ApartadoLugarDeInteres.this);
        adaptadorLugar = new AdaptadorLugar(this, dbLugaresInteres.mostrarlugares());
        recyclerView.setAdapter(adaptadorLugar);


        DBHelper dbhelper = new DBHelper(ApartadoLugarDeInteres.this);
        SQLiteDatabase db = dbhelper.getWritableDatabase();
    }

    public void CrearLugarInteres(View clic) {
        Intent CrearLugarInteres = new Intent(this, CrearLugaresInteres.class);
        startActivity(CrearLugarInteres);
    }

}