package com.example.boxinventario.clases;

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

import com.example.boxinventario.R;
import com.example.boxinventario.db.DBHelper;
import com.example.boxinventario.db.DBProductos;
import com.example.boxinventario.entidades.Producto;

public class DescripcionProductos extends AppCompatActivity {

    private int IDproducto;
    private SQLiteDatabase DB;

    private EditText nombreprod , numrcantidad , numrprecio , nombcategoria , nomrubicacion , numrfecha;
    Button btnEliminar, btnEditar, btnGuardar;
    int id = 0;
    Producto productos;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descipcion_productos);


        //campo de textos
        nombreprod = findViewById(R.id.nombreproducto);
        numrcantidad = findViewById(R.id.numerodecantidad);
        numrprecio = findViewById(R.id.numerodeprecio);
        nombcategoria = findViewById(R.id.nombredecategoria);
        nomrubicacion = findViewById(R.id.nombredeubicacion);
        numrfecha = findViewById(R.id.numerodefecha);

        //botones
        btnEliminar = findViewById(R.id.btnEliminar);
        btnEditar = findViewById(R.id.btnEditar);
        btnGuardar = findViewById(R.id.btnGuardar);

        nombreprod.setEnabled(false);
        numrcantidad.setEnabled(false);
        numrprecio.setEnabled(false);
        nombcategoria.setEnabled(false);
        nomrubicacion.setEnabled(false);
        numrfecha.setEnabled(false);

        btnGuardar.setVisibility(View.INVISIBLE);

        //ver producto
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

        DBProductos dbProductos = new DBProductos(this);
        productos = dbProductos.verdatos(id);

        if (productos!= null){
            nombreprod.setText(productos.getNameproducto());
            numrcantidad.setText(productos.getCantidad());
            numrprecio.setText(productos.getPrecio());
            nombcategoria.setText(productos.getCategoria());
            nomrubicacion.setText(productos.getUbicacion());
            numrfecha.setText(productos.getFechaproducto());
        }

        final boolean[] ready = {false};

        btnEditar.setOnClickListener(v -> {

            btnGuardar.setVisibility(View.VISIBLE);
            btnEliminar.setVisibility(View.INVISIBLE);
            btnEditar.setVisibility(View.INVISIBLE);
            nombreprod.setEnabled(true);
            numrcantidad.setEnabled(true);
            numrprecio.setEnabled(true);
            nombcategoria.setEnabled(true);
            nomrubicacion.setEnabled(true);
            numrfecha.setEnabled(true);

            btnGuardar.setOnClickListener(v1 -> {
                if(!nombreprod.getText().toString().equals("")&&!numrcantidad.getText().equals("")&& !numrprecio.getText().equals("") && !nombcategoria.getText().equals("")&& !nomrubicacion.getText().equals("")&& !numrfecha.getText().equals("")){

                    Editable nom = (nombreprod.getText());
                    Editable can = (numrcantidad.getText());
                    Editable pre = (numrprecio.getText());
                    Editable cat = (nombcategoria.getText());
                    Editable ubi = (nomrubicacion.getText());
                    Editable fec = (numrfecha.getText());

                    ready[0] = dbProductos.editProducto(id,nom,fec,can,pre,ubi,cat);


                    Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

                    if (ready[0]){
                        Toast.makeText(DescripcionProductos.this, "Modificacion realizada", Toast.LENGTH_SHORT).show();
                        nombreprod.setEnabled(false);
                        numrcantidad.setEnabled(false);
                        numrprecio.setEnabled(false);
                        nombcategoria.setEnabled(false);
                        nomrubicacion.setEnabled(false);
                        numrfecha.setEnabled(false);
                        btnGuardar.setVisibility(View.INVISIBLE);
                        btnEditar.setVisibility(View.VISIBLE);
                        btnEliminar.setVisibility(View.VISIBLE);
                    }else {
                        Toast.makeText(DescripcionProductos.this, "Error al modificar su Producto", Toast.LENGTH_SHORT).show();
                        nombreprod.setEnabled(false);
                        numrcantidad.setEnabled(false);
                        numrprecio.setEnabled(false);
                        nombcategoria.setEnabled(false);
                        nomrubicacion.setEnabled(false);
                        numrfecha.setEnabled(false);
                        btnGuardar.setVisibility(View.INVISIBLE);
                        btnEditar.setVisibility(View.VISIBLE);
                        btnEliminar.setVisibility(View.VISIBLE);
                    }
                }else {
                    Toast.makeText(DescripcionProductos.this, "DEBE LLENAR LOS CAMPOS OBLIGATORIOS", Toast.LENGTH_SHORT).show();
                    nombreprod.setEnabled(false);
                    numrcantidad.setEnabled(false);
                    numrprecio.setEnabled(false);
                    nombcategoria.setEnabled(false);
                    nomrubicacion.setEnabled(false);
                    numrfecha.setEnabled(false);
                    btnGuardar.setVisibility(View.INVISIBLE);
                    btnEditar.setVisibility(View.VISIBLE);
                    btnEliminar.setVisibility(View.VISIBLE);
                }
            });
        });

        DBHelper dbHelper = new DBHelper(this);
        DB = dbHelper.getWritableDatabase();

        btnEliminar.setOnClickListener(v -> {

            AlertDialog.Builder builder = new AlertDialog.Builder(DescripcionProductos.this);
            builder.setMessage("¿Desea eliminar este producto?").setPositiveButton("Si", (dialog, i) -> {
                if(dbProductos.eliminarProducto(id)){
                    lista();
                }
            }).setNegativeButton("No", (dialog, i) -> {

            }).show();
        });
    }
    private void lista() {
        Intent intent = new Intent(this, Inventario.class);
        startActivity(intent);
    }
}