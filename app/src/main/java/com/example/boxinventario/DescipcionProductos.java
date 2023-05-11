package com.example.boxinventario;

import static com.example.boxinventario.R.id.btnEditar;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.boxinventario.db.DBHelper;
import com.example.boxinventario.db.DBProductos;
import com.example.boxinventario.entidades.Producto;

public class DescipcionProductos extends AppCompatActivity {

    private int IDproducto;
    private SQLiteDatabase DB;

    private TextView nombreprod , numrcantidad , numrprecio , nombcategoria , nomrubicacion , numrfecha;
    Button btnEditar;
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
        btnEditar = findViewById(R.id.btnEditar);

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

        DBHelper dbHelper = new DBHelper(this);
        DB = dbHelper.getWritableDatabase();
        /*


        /*
        String nombre = intent.getStringExtra("Nombre");
        String cantidad = intent.getStringExtra("Fecha");
        String precio = intent.getStringExtra("Cantidad");
        String categoria = intent.getStringExtra("Precio");
        String ubicacion = intent.getStringExtra("Categoria");
        String fecha = intent.getStringExtra("Ubicacion");


        TextView nombreprod = findViewById(R.id.nombreproducto);
        TextView numrcantidad= findViewById(R.id.numerodecantidad);
        TextView numrprecio= findViewById(R.id.numerodeprecio);
        TextView nombcategoria= findViewById(R.id.nombredecategoria);
        TextView nomrubicacion= findViewById(R.id.nombredeubicacion);
        TextView numrfecha= findViewById(R.id.numerodefecha);

        /*
        nombreprod.setText(nombre);
        numrcantidad.setText(cantidad);
        numrprecio.setText(precio);
        nombcategoria.setText(categoria);
        nomrubicacion.setText(ubicacion);
        numrfecha.setText(fecha);

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
        */
    }

    public void IraEditar(View clic) {
        Intent IraEditar = new Intent(this, EditadEliminar.class);
        startActivity(IraEditar);
    }
}