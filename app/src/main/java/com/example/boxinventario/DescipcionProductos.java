package com.example.boxinventario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.boxinventario.entidades.Producto;

public class DescipcionProductos extends AppCompatActivity {

    ImageView imagproducto;
    TextView nombreprod;
    TextView numrcantidad;
    TextView numrprecio;
    TextView nombcategoria;
    TextView nomrubicacion;
    TextView numrfecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descipcion_productos);

        Producto element = (Producto) getIntent().getSerializableExtra("Producto");

        Log.i("PRODUCTO DESCRIPCION", element.getNameproducto());
        //imagproducto = findViewById(R.id.imagendeproducto);
        nombreprod = findViewById(R.id.nombreproducto);
        numrcantidad = findViewById(R.id.numerodecantidad);
        numrprecio = findViewById(R.id.numerodeprecio);
        nombcategoria = findViewById(R.id.nombredecategoria);
        nomrubicacion = findViewById(R.id.nombredeubicacion);
        numrfecha = findViewById(R.id.numerodefecha);

        //imagendeproducto.setColorFilter(Color.parseColor(element.getColor()));
        nombreprod.setText(element.getNameproducto());
        numrcantidad.setText(element.getCantidad());
        numrprecio.setText(element.getPrecio());
        nombcategoria.setText(element.getCategoria());
        nomrubicacion.setText(element.getUbicacion());
        numrfecha.setText(element.getFechaproducto());
        //((CharSequence)
    }
}