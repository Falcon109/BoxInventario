package com.example.boxinventario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.boxinventario.clases.ApartadoLugarDeInteres;
import com.example.boxinventario.db.DBLugaresInteres;

public class CrearLugaresInteres extends AppCompatActivity {

    EditText nombre_lugar, link_lugar , puntaje;

    Button btnguardarlugar;
    DBLugaresInteres DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_lugares_interes);

        nombre_lugar = findViewById(R.id.nameubiacioninteres);
        link_lugar = findViewById(R.id.enlacedelugar);
        puntaje = findViewById(R.id.puntajedelLugar);
        btnguardarlugar = findViewById(R.id.btnGuardarLugar);

        DB = new DBLugaresInteres(this);

        btnguardarlugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombrelug = nombre_lugar.getText().toString();
                String linklug = link_lugar.getText().toString();
                Integer puntajelug = Integer.valueOf(puntaje.getText().toString());

                Boolean checkinsetproducto = DB.inserLugaresInteres(nombrelug,linklug,puntajelug);
                if (checkinsetproducto==true) {
                    Toast.makeText(CrearLugaresInteres.this, "Lugar de interes guardado", Toast.LENGTH_LONG).show();
                    limpiar();
                } else {
                    Toast.makeText(CrearLugaresInteres.this, "Error al crear lugar de interes", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void limpiar(){
        nombre_lugar.setText("");
        link_lugar.setText("");
        puntaje.setText("");
    }

    public void Cancelar(View clic) {
        Intent Cancelar = new Intent(this, ApartadoLugarDeInteres.class);
        startActivity(Cancelar);
    }

}