package com.example.boxinventario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ApartadoLista extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartado_lista);
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

}