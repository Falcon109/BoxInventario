package com.example.boxinventario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CreacionLista extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creacion_lista);
    }

    public void VolverMenu (View clic9) {
        Intent Volvermenu = new Intent(this, MainActivity.class);
        startActivity(Volvermenu);
    }

}