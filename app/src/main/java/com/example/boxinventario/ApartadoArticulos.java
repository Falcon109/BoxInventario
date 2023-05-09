package com.example.boxinventario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.boxinventario.adapted.AdaptadorProducto;
import com.example.boxinventario.db.DBHelperproductos;
import com.example.boxinventario.entidades.Producto;

import java.util.ArrayList;
import java.util.List;

public class ApartadoArticulos extends AppCompatActivity {
    DBHelperproductos DB;
    RecyclerView recyclerView;
    SQLiteDatabase sqLiteDatabase;
    AdaptadorProducto adaptadorProducto;

    //ArrayList<String> nombproducto , numcantidad , numprecio, nombcategoria, nombubicacion, numfecha ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartado_articulos);
        DB = new DBHelperproductos(this);
        identificar();
        mostrardatos();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void mostrardatos() {
        sqLiteDatabase = DB.getReadableDatabase();
        Producto producto;
        List<Producto> productos = new ArrayList<>(); // Crear una lista de productos vacía

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + DB.TABLE_PRODUCTOS, null);
        while (cursor.moveToNext()) { // Recorrer los resultados de la consulta
            int id = cursor.getInt(0);
            String nombrepro = cursor.getString(1);
            String numfech = cursor.getString(2);
            String numcanti = cursor.getString(3);
            String numprec = cursor.getString(4);
            String nomubica = cursor.getString(6);
            String nomcateg = cursor.getString(5);

            producto = new Producto(id,nombrepro,numfech,numcanti,numprec,nomubica,nomcateg); // Crear un objeto Producto
            productos.add(producto); // Agregar el objeto a la lista de productos
        }

        cursor.close(); // Cerrar el cursor
        sqLiteDatabase.close(); // Cerrar la conexión con la base de datos

        // Crear un adaptador personalizado para el RecyclerView y pasarle la lista de productos
        AdaptadorProducto adaptador = new AdaptadorProducto((ArrayList<Producto>) productos);
        recyclerView.setAdapter(adaptador);
    }



    private void identificar() {
        recyclerView = findViewById(R.id.listacuerpo);
    }

    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartado_articulos);

        DB = new DBHelperproductos(this);
        nombproducto = new ArrayList<>();
        numcantidad = new ArrayList<>();
        numprecio = new ArrayList<>();
        nombcategoria = new ArrayList<>();
        nombubicacion = new ArrayList<>();
        numfecha = new ArrayList<>();
        recyclerView = findViewById(R.id.listacuerpo);
        adaptadorProducto = new AdaptadorProducto(this,nombproducto,numfecha,numcantidad,numprecio,nombcategoria,nombubicacion);
        recyclerView.setAdapter(adaptadorProducto);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
    }

    public void init(){
        elementos = new ArrayList<>();
        elementos.add(new Producto("Galletas", "12-23-31", "4", "1200", "jumbo","Cofis"));
        elementos.add(new Producto("Bebidas", "12-23-31", "2", "2000", "jumbo","Gaseosas"));
        elementos.add(new Producto("Papas", "12-23-31", "3", "1800", "jumbo","Cofis"));
        elementos.add(new Producto("Carne", "12-23-31", "4", "5600", "jumbo","Canes"));
        elementos.add(new Producto("Jugos", "12-23-31", "6", "2100", "jumbo","Liquidos"));
        elementos.add(new Producto("Mayonesa", "12-23-31", "2", "3200", "jumbo","Agregados"));
        elementos.add(new Producto("Confort", "12-23-31", "16", "12000", "jumbo","Otros"));


        RecyclerView recyclerView = findViewById(R.id.listacuerpo);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptadorProducto);
    }*/


    public void moveToDescription(Producto item) {
        Intent intent = new Intent(this, DescipcionProductos.class);
        intent.putExtra("Producto", (Parcelable) item);
        startActivity(intent);
    }

    public void Crearproducto(View clic) {
        Intent Crearproducto = new Intent(this, CrearProductos.class);
        startActivity(Crearproducto);
    }


}