package com.example.boxinventario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ApartadoLugarDeInteres extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartado_lugar_de_interes);
    }

    public void VolverMenu (View clic10) {
        Intent Volvermenu = new Intent(this, MainActivity.class);
        startActivity(Volvermenu);
    }


}