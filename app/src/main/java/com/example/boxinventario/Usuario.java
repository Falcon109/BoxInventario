package com.example.boxinventario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Usuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);
    }

    //Metodo para ir a crear Lugares de interes
    public void VolverMenu (View clic6) {
        Intent Volvermenu = new Intent(this, MainActivity.class);
        startActivity(Volvermenu);
    }

}