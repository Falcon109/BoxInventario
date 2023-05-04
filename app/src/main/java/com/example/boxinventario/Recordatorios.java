package com.example.boxinventario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.boxinventario.adapted.AdaptadorListas;
import com.example.boxinventario.entidades.ListaRecordatorio;
import com.example.boxinventario.entidades.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Recordatorios extends AppCompatActivity {

    List<ListaRecordatorio> elementos2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordatorios);

        init2();

    }

    public void init2() {
        elementos2 = new ArrayList<>();
        elementos2.add(new ListaRecordatorio("#775447", "Compras Casa", "1 de abril", "Desactivada"));
        elementos2.add(new ListaRecordatorio("#775447", "Fiesta", "22 de abril", "Activada"));
        elementos2.add(new ListaRecordatorio("#775447", "Cumpleaños", "10 de abril", "Activada"));

        AdaptadorListas adaptadorListas = new AdaptadorListas(elementos2, this);
        RecyclerView recyclerView = findViewById(R.id.cuerpoRecordatorio);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptadorListas);

    }
}