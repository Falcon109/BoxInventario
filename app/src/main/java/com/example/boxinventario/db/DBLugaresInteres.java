package com.example.boxinventario.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.Editable;

import androidx.annotation.Nullable;

import com.example.boxinventario.entidades.LugaresDeInteres;

import java.util.ArrayList;

public class DBLugaresInteres extends DBHelper {

    private Context context;
    private SQLiteDatabase db;

    public DBLugaresInteres(@Nullable Context context){
        super(context);
        this.context = context;
    }

    public Boolean inserLugaresInteres(String nombre_lugar, String link_lugar, Integer puntaje){
        SQLiteDatabase db = this.getWritableDatabase();

        DBHelper dbhelper = new DBHelper(context);
        this.db = dbhelper.getWritableDatabase();

        ContentValues contentValue = new ContentValues();
        contentValue.put("nombre_lugar", nombre_lugar);
        contentValue.put("link_ubicacion", link_lugar);
        contentValue.put("puntaje", puntaje);
        long result = db.insert(TABLE_UBICACION,null,contentValue);
        if (result == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    @SuppressLint("Recycle")
    public ArrayList<LugaresDeInteres> mostrarlugares() {

        DBHelper dbhelper = new DBHelper(context);
        this.db = dbhelper.getWritableDatabase();

        ArrayList<LugaresDeInteres> Listlugares = new ArrayList<>();
        LugaresDeInteres lugaresDeInteres = new LugaresDeInteres();
        Cursor cursorlugares;

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_UBICACION, null);
        while (cursor.moveToNext()) { // Recorrer los resultados de la consulta
            int id = cursor.getInt(0);
            String nomb_lug = cursor.getString(1);
            String link_ubi = cursor.getString(2);
            String punt = cursor.getString(3);

            lugaresDeInteres = new LugaresDeInteres(id, nomb_lug, link_ubi, punt);
            Listlugares.add(lugaresDeInteres); // Agregar el objeto a la lista de productos
        }

        cursor.close(); // Cerrar el cursor
        db.close(); // Cerrar la conexión con la base de datos
        return Listlugares;
    }

    public LugaresDeInteres verdatoslugares(int ID) {

        DBHelper dbhelper = new DBHelper(context);
        this.db = dbhelper.getWritableDatabase();

        LugaresDeInteres lugaresDeInteres = null;
        Cursor cursorlugares;

        cursorlugares = db.rawQuery("SELECT * FROM " + TABLE_UBICACION +" WHERE id_ubicacion = '" + ID + "' LIMIT 1", null);

        while (cursorlugares.moveToNext()) { // Recorrer los resultados de la consulta
            lugaresDeInteres = new LugaresDeInteres();
            lugaresDeInteres.setId_lugares(cursorlugares.getInt(0));
            lugaresDeInteres.setNombre_lugar(cursorlugares.getString(1));
            lugaresDeInteres.setLink(cursorlugares.getString(2));
            lugaresDeInteres.setPuntaje(cursorlugares.getString(3));
        }
        cursorlugares.close(); // Cerrar el cursor
        return lugaresDeInteres;
    }

    public boolean eliminarLugares(int ID) {

        boolean ready;
        DBHelper dbhelper = new DBHelper(context);
        this.db = dbhelper.getWritableDatabase();
        try {
            db.execSQL("DELETE FROM " + TABLE_UBICACION + " WHERE id_ubicacion = '" + ID + "'");
            ready = true;
        } catch (Exception ex) {
            ex.toString();
            ready = false;
        }finally {
            db.close();
        }

        return ready;
    }
    public boolean editLugares(int id_ubicacion, Editable nombre_lugar, Editable link_ubicacion, Editable puntaje) {

        boolean ready = false;
        DBHelper dbhelper = new DBHelper(context);
        this.db = dbhelper.getWritableDatabase();
        try {
            db.execSQL("UPDATE " + TABLE_UBICACION + " SET nombre_lugar ='" + nombre_lugar + "', link_ubicacion ='" + link_ubicacion + "', puntaje ='" + puntaje + "' WHERE id_ubicacion = '" + id_ubicacion + "'");
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
