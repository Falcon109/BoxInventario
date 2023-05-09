package com.example.boxinventario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.boxinventario.entidades.Usuario;

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

    //Metodo para ir a articulos
    public void IrArticulos(View clic1) {
        Intent IrArticulos = new Intent(this, ApartadoArticulos.class);
        startActivity(IrArticulos);
    }

    //Metodo para ir a listas
    public void IrLista(View clic2) {
        Intent IraLista = new Intent(this, ApartadoListas.class);
        startActivity(IraLista);
    }

    //Metodo para ir a Lugares de interes
    public void IrLugarInteres(View clic4) {
        Intent IrLugarInteres = new Intent(this, ApartadoLugarDeInteres.class);
        startActivity(IrLugarInteres);
    }

    //Metodo para Gestionar Recordatorios
    public void IrRecordatorios (View clic5) {
        Intent IraRecordarorios = new Intent(this, Recordatorios.class);
        startActivity(IraRecordarorios);
    }

}