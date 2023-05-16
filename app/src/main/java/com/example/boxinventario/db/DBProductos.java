package com.example.boxinventario.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.Editable;

import androidx.annotation.Nullable;

import com.example.boxinventario.entidades.Producto;

import java.util.ArrayList;

public class DBProductos extends DBHelper {

    private Context context;
    private SQLiteDatabase db;

    public DBProductos(@Nullable Context context){
        super(context);
        this.context = context;
    }

    public Boolean inserProductos(String nameproducto, String fechaproducto, Integer cantidad, Integer precio, String ubicacion, String categoria){
        SQLiteDatabase db = this.getWritableDatabase();

        DBHelper dbhelper = new DBHelper(context);
        this.db = dbhelper.getWritableDatabase();

        ContentValues contentValue = new ContentValues();
        contentValue.put("nameproducto", nameproducto);
        contentValue.put("fechaproducto", fechaproducto);
        contentValue.put("cantidad", cantidad);
        contentValue.put("precio", precio);
        contentValue.put("ubicacion", ubicacion);
        contentValue.put("categoria", categoria);
        long result = db.insert(TABLE_PRODUCTOS,null,contentValue);
        if (result == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    @SuppressLint("Recycle")
    public ArrayList<Producto> mostrardatos() {

        DBHelper dbhelper = new DBHelper(context);
        this.db = dbhelper.getWritableDatabase();

        ArrayList<Producto> Listproductos = new ArrayList<>();
        Producto producto = new Producto();
        Cursor cursorproduct;

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_PRODUCTOS, null);
        while (cursor.moveToNext()) { // Recorrer los resultados de la consulta
            int id = cursor.getInt(0);
            String nombrepro = cursor.getString(1);
            String numfech = cursor.getString(2);
            String numcanti = cursor.getString(3);
            String numprec = cursor.getString(4);
            String nomubica = cursor.getString(6);
            String nomcateg = cursor.getString(5);

            producto = new Producto(id,nombrepro,numfech,numcanti,numprec,nomubica,nomcateg); // Crear un objeto Producto
            Listproductos.add(producto); // Agregar el objeto a la lista de productos
        }

        cursor.close(); // Cerrar el cursor
        db.close(); // Cerrar la conexión con la base de datos
        return Listproductos;
    }

    public Producto verdatos(int ID) {

        DBHelper dbhelper = new DBHelper(context);
        this.db = dbhelper.getWritableDatabase();

        Producto producto = null;
        Cursor cursorproduct;

        cursorproduct = db.rawQuery("SELECT * FROM " + TABLE_PRODUCTOS +" WHERE id = '" + ID + "' LIMIT 1", null);

        while (cursorproduct.moveToNext()) { // Recorrer los resultados de la consulta
            producto = new Producto();
            producto.setId(cursorproduct.getInt(0));
            producto.setNameproducto(cursorproduct.getString(1));
            producto.setFechaproducto( cursorproduct.getString(2));
            producto.setCantidad( cursorproduct.getString(3));
            producto.setPrecio( cursorproduct.getString(4));
            producto.setUbicacion( cursorproduct.getString(5));
            producto.setCategoria( cursorproduct.getString(6));
        }
        cursorproduct.close(); // Cerrar el cursor
        return producto;
    }

    public boolean eliminarProducto(int ID) {

        boolean ready;
        DBHelper dbhelper = new DBHelper(context);
        this.db = dbhelper.getWritableDatabase();
        try {
            db.execSQL("DELETE FROM " + TABLE_PRODUCTOS + " WHERE id= '" + ID + "'");
            ready = true;
        } catch (Exception ex) {
            ex.toString();
            ready = false;
        }finally {
            db.close();
        }

        return ready;
    }

    public boolean editProducto(int ID, Editable nameproducto, Editable fechaproducto, Editable cantidad, Editable precio, Editable Ubicacion, Editable categoria) {

        boolean ready = false;
        DBHelper dbhelper = new DBHelper(context);
        this.db = dbhelper.getWritableDatabase();
        try {
            db.execSQL("UPDATE " + TABLE_PRODUCTOS + " SET nameproducto = '" + nameproducto+ "', fechaproducto ='" + fechaproducto + "', cantidad ='" + cantidad + "', precio ='" + precio +"', Ubicacion ='" + Ubicacion + "', categoria ='" + categoria + "' WHERE id= '" + ID + "'");
            ready = true;
        } catch (Exception ex) {
            ex.toString();
            ready = false;
        }finally {
            db.close();
        }

        return ready;
    }

}
