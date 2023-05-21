package com.example.boxinventario;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.boxinventario.clases.ApartadoLugarDeInteres;
import com.example.boxinventario.clases.DescripcionProductos;
import com.example.boxinventario.clases.Inventario;
import com.example.boxinventario.db.DBHelper;
import com.example.boxinventario.db.DBLugaresInteres;
import com.example.boxinventario.db.DBProductos;
import com.example.boxinventario.entidades.LugaresDeInteres;
import com.example.boxinventario.entidades.Producto;

public class DescripcionLugares extends AppCompatActivity {

    private SQLiteDatabase DB;

    private EditText nombrelugar , enlacelugar, puntaje;
    Button btnEliminar, btnEditar, btnGuardar;
    int id = 0;
    LugaresDeInteres lugaresDeInteres;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_lugares);

        //campo de textos
        nombrelugar = findViewById(R.id.nombreubicacion);
        enlacelugar = findViewById(R.id.enlacedelugar);
        puntaje = findViewById(R.id.puntajedelLugar);


        //botones
        btnEliminar = findViewById(R.id.btnEliminar2);
        btnEditar = findViewById(R.id.btnEditar2);
        btnGuardar = findViewById(R.id.btnGuardar2);

        nombrelugar.setEnabled(false);
        enlacelugar.setEnabled(false);
        puntaje.setEnabled(false);

        btnGuardar.setVisibility(View.INVISIBLE);

        if(savedInstanceState==null){
            Bundle extra = getIntent().getExtras();
            if (extra==null){
                id = Integer.parseInt(null);
            }else {
                id = extra.getInt("ID");
            }
        }else {
            id = (int) savedInstanceState.getSerializable("ID");
        }

        DBLugaresInteres dbLugaresInteres = new DBLugaresInteres(this);
        lugaresDeInteres = dbLugaresInteres.verdatoslugares(id);

        if (lugaresDeInteres!= null){
            nombrelugar.setText(lugaresDeInteres.getNombre_lugar());
            enlacelugar.setText(lugaresDeInteres.getLink());
            puntaje.setText(lugaresDeInteres.getPuntaje());
        }

        final boolean[] ready = {false};

        btnEditar.setOnClickListener(v -> {

            btnGuardar.setVisibility(View.VISIBLE);
            btnEliminar.setVisibility(View.INVISIBLE);
            btnEditar.setVisibility(View.INVISIBLE);
            nombrelugar.setEnabled(true);
            enlacelugar.setEnabled(true);
            puntaje.setEnabled(true);

            btnGuardar.setOnClickListener(v1 -> {
                if(!nombrelugar.getText().toString().equals("")&&!enlacelugar.getText().equals("")&& !puntaje.getText().equals("")){

                    Editable nomlug = (nombrelugar.getText());
                    Editable linklug = (enlacelugar.getText());
                    Editable puntlug = (puntaje.getText());

                    ready[0] = dbLugaresInteres.editLugares(id,nomlug,linklug,puntlug);


                    Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

                    if (ready[0]){
                        Toast.makeText(DescripcionLugares.this, "Modificacion realizada", Toast.LENGTH_SHORT).show();
                        nombrelugar.setEnabled(false);
                        enlacelugar.setEnabled(false);
                        puntaje.setEnabled(false);
                        btnGuardar.setVisibility(View.INVISIBLE);
                        btnEditar.setVisibility(View.VISIBLE);
                        btnEliminar.setVisibility(View.VISIBLE);
                    }else {
                        Toast.makeText(DescripcionLugares.this, "Error al modificar su Producto", Toast.LENGTH_SHORT).show();
                        nombrelugar.setEnabled(false);
                        enlacelugar.setEnabled(false);
                        puntaje.setEnabled(false);
                        btnGuardar.setVisibility(View.INVISIBLE);
                        btnEditar.setVisibility(View.VISIBLE);
                        btnEliminar.setVisibility(View.VISIBLE);
                    }
                }else {
                    Toast.makeText(DescripcionLugares.this, "DEBE LLENAR LOS CAMPOS OBLIGATORIOS", Toast.LENGTH_SHORT).show();
                    nombrelugar.setEnabled(false);
                    enlacelugar.setEnabled(false);
                    puntaje.setEnabled(false);
                    btnGuardar.setVisibility(View.INVISIBLE);
                    btnEditar.setVisibility(View.VISIBLE);
                    btnEliminar.setVisibility(View.VISIBLE);
                }
            });
        });

        DBHelper dbHelper = new DBHelper(this);
        DB = dbHelper.getWritableDatabase();

        btnEliminar.setOnClickListener(v -> {

            AlertDialog.Builder builder = new AlertDialog.Builder(DescripcionLugares.this);
            builder.setMessage("¿Desea eliminar este producto?").setPositiveButton("Si", (dialog, i) -> {
                if(dbLugaresInteres.eliminarLugares(id)){
                    lista();
                }
            }).setNegativeButton("No", (dialog, i) -> {

            }).show();
        });
    }
    private void lista() {
        Intent intent = new Intent(this, ApartadoLugarDeInteres.class);
        startActivity(intent);
    }
}