package com.example.boxinventario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Recordatorios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordatorios);
    }

    public void VolverMenu (View clic11) {
        Intent Volvermenu = new Intent(this, MainActivity.class);
        startActivity(Volvermenu);
    }

    public void IrUsuario(View clic12) {
        Intent IraUsuario = new Intent(this, Usuario.class);
        startActivity(IraUsuario);
    }

}