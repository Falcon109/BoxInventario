package com.example.boxinventario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.boxinventario.MainActivity;
import com.example.boxinventario.R;
import com.example.boxinventario.adapted.ListaAdaptador2;
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

    public void VolverMenu(View clic11) {
        Intent Volvermenu = new Intent(this, MainActivity.class);
        startActivity(Volvermenu);
    }

    public void IrUsuario(View clic12) {
        Intent IraUsuario = new Intent(this, Usuario.class);
        startActivity(IraUsuario);
    }

    public void init2() {
        elementos2 = new ArrayList<>();
        elementos2.add(new ListaRecordatorio("#775447", "Compras Casa", "1 de abril", "Desactivada"));
        elementos2.add(new ListaRecordatorio("#775447", "Fiesta", "22 de abril", "Activada"));
        elementos2.add(new ListaRecordatorio("#775447", "Cumpleaños", "10 de abril", "Activada"));

        ListaAdaptador2 listaAdaptador2 = new ListaAdaptador2(elementos2, this);
        RecyclerView recyclerView = findViewById(R.id.cuerpoRecordatorio);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listaAdaptador2);

    }
}