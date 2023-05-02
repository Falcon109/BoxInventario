package com.example.boxinventario.entidades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.boxinventario.MainActivity;
import com.example.boxinventario.R;

public class Usuario extends AppCompatActivity {

    private EditText texnombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        texnombre = (EditText)findViewById(R.id.NombreUsuario);

    }

    //Metodo para ir a crear Lugares de interes
    public void VolverMenu (View clic6) {
        Intent Volvermenu = new Intent(this, MainActivity.class);
        startActivity(Volvermenu);
    }

    //metodo para guardar nombre del usuario
    public void LoginNombre(View nombre){

        String nomb = texnombre.getText().toString();

        if(nomb.length()==0){
            Toast.makeText(this,"Debes ingresar un nombre",Toast.LENGTH_LONG).show();
        }
        if(nomb.length()!=0){
            //Toast.makeText(this,"Bienvenido "+nomb,Toast.LENGTH_LONG).show();
            texnombre.setText(nomb);
        }

    }

}