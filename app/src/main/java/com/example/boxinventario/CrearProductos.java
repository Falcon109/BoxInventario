package com.example.boxinventario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.boxinventario.db.DBHelperproductos;
import com.example.boxinventario.db.DBProductos;
import com.example.boxinventario.entidades.Usuario;

public class CrearProductos extends AppCompatActivity {

    EditText nombproducto , numcantidad , numprecio, nombcategoria, nombubicacion, numfecha ;

    Button btnguardar;
    DBHelperproductos DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_productos);

        nombproducto = findViewById(R.id.nombreproducto);
        numcantidad = findViewById(R.id.numerodecantidad);
        numprecio = findViewById(R.id.numerodeprecio);
        nombcategoria = findViewById(R.id.nombredecategoria);
        nombubicacion = findViewById(R.id.nombredeubicacion);
        numfecha = findViewById(R.id.numerodefecha);
        btnguardar = findViewById(R.id.guardar);

        DB = new DBHelperproductos(this);

        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombrepro = nombproducto.getText().toString();
                String numfech = numfecha.getText().toString();
                Integer numcanti = Integer.valueOf(numcantidad.getText().toString());
                Integer numprec = Integer.valueOf(numprecio.getText().toString());
                String nomubica = nombubicacion.getText().toString();
                String nomcateg = nombcategoria.getText().toString();

                Boolean checkinsetproducto = DB.inserProductos(nombrepro,numfech,numcanti,numprec,nomubica,nomcateg);
                if (checkinsetproducto==true) {
                    Toast.makeText(CrearProductos.this, "Producto guardado", Toast.LENGTH_LONG).show();
                    limpiar();
                } else {
                    Toast.makeText(CrearProductos.this, "Error al guardar producto", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void limpiar(){
        nombproducto.setText("");
        numcantidad.setText("");
        numprecio.setText("");
        nombcategoria.setText("");
        nombubicacion.setText("");
        numfecha.setText("");
    }

    public void Cancelar(View clic) {
        Intent Cancelar = new Intent(this, ApartadoArticulos.class);
        startActivity(Cancelar);
    }
}
