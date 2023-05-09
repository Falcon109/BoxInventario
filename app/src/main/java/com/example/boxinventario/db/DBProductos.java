package com.example.boxinventario.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DBProductos extends DBHelperproductos {

    private Context context;

    public DBProductos(@Nullable Context context){
        super(context);
        this.context = context;
    }

    /*public void close() {
        dbHelper.close();
    }*/

    public long insertProduct(String nameproducto, String fechaproducto, Integer cantidad, Integer precio, String ubicacion, String categoria) {
        long id = 0;
        try {
            DBHelperproductos dbHelperproductos = new DBHelperproductos(context);
            SQLiteDatabase db = dbHelperproductos.getWritableDatabase();

            ContentValues contentValue = new ContentValues();
            contentValue.put("nameproducto", nameproducto);
            contentValue.put("fechaproducto", fechaproducto);
            contentValue.put("cantidad", cantidad);
            contentValue.put("precio", precio);
            contentValue.put("ubicacion", ubicacion);
            contentValue.put("categoria", categoria);
            db.insert(TABLE_PRODUCTOS, null, contentValue);

        } catch (Exception ex){
            ex.toString();
        }
        return id;
    }

    /*
    public Cursor fetchProducts() {
        String[] columns = new String[] { "id","name","amount","quantity", "expiration"};
        Cursor cursor = database.query(dbHelper.TABLE_PRODUCTOS, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
    public int update(long _id, String name, Integer amount, Integer quantity, String expiration) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("amount", amount);
        contentValues.put("quantity", quantity);
        contentValues.put("expiration", expiration);
        int i = database.update(dbHelper.TABLE_PRODUCTOS, contentValues, "ID = " + _id, null);
        return i;
    }
    public void delete(long _id) {
        database.delete(dbHelper.TABLE_PRODUCTOS, "ID = " + _id, null);
    }*/

}
