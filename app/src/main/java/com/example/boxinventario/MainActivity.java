package com.example.boxinventario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Metodos para moverse entre ventanas o activitis
    //Metodo para ir a Usuario
    public void IrUsuario(View clic) {
        Intent IraUsuario = new Intent(this, Usuario.class);
        startActivity(IraUsuario);
    }

    //Metodo para ir a Lista creadas
    public void IrLista(View clic1) {
        Intent IraLista = new Intent(this, ApartadoLista.class);
        startActivity(IraLista);
    }

    //Metodo para ir a creacion de listas
    public void IrCrearLista (View clic2) {
        Intent IraCrearLista = new Intent(this, CreacionLista.class);
        startActivity(IraCrearLista);
    }

    //Metodo para ir a Lugar de interes
    /*public void IrLugarInteres (View clic3) {
        Intent IraLugarInteres = new Intent(this, CreacionLista.class);
        startActivity(IraCrear);
    }*/

    //Metodo para ir a crear Lugares de interes
    public void IrCrearLugarInteres (View clic4) {
        Intent IraCrearLugarInteres = new Intent(this, ApartadoLugarDeInteres.class);
        startActivity(IraCrearLugarInteres);
    }

    //Metodo para Gestionar Recordatorios
    public void IrRecordatorios (View clic5) {
        Intent IraRecordarorios = new Intent(this, Recordatorios.class);
        startActivity(IraRecordarorios);
    }

}