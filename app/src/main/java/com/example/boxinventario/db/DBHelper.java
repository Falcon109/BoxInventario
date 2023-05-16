package com.example.boxinventario.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 7;
    private static final String DATABASE_NAME = "productos.db";

    //private static final String CREATE_TABLE = "CREATE TABLE type (id INTEGER PRIMARY KEY, nameproducto TEXT, fechaproducto TEXT, cantidad INTEGER, Ubicacion TEXT, categoria TEXT, precio INTEGER)";
    public String TABLE_PRODUCTOS = "t_productos";
    public String TABLE_LISTAS = "t_listas";
    public String TABLE_UBICACION = "t_ubicacion";
    public String TABLE_RECORDATORIO = "t_recordatorio";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_PRODUCTOS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nameproducto TEXT NOT NULL," +
                "fechaproducto TEXT NOT NULL,"+
                "cantidad NUMERIC NOT NULL,"+
                "precio NUMERIC NOT NULL,"+
                "Ubicacion TEXT NOT NULL,"+
                "categoria TEXT NOT NULL)");

        db.execSQL("CREATE TABLE "+ TABLE_LISTAS + "(" +
                "id_listas INTEGRE PRIMARY KEY,"+
                "nombre_lista TEXT NOT NULL," +
                "cantidad INTEGRE NOT NULL)");

        db.execSQL("CREATE TABLE "+ TABLE_UBICACION + "(" +
                "id_ubicacion INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "link_ubicacion TEXT NOT NULL,"+
                "puntaje INTEGER NOT NULL)");

        db.execSQL("CREATE TABLE "+ TABLE_RECORDATORIO + "("+
                "id_recordatorio INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "fecha TEXT NOT NULL,"+
                "Estado TEXT NOT NULL)");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE "+this.TABLE_PRODUCTOS);
        db.execSQL("DROP TABLE "+this.TABLE_LISTAS);
        db.execSQL("DROP TABLE "+this.TABLE_UBICACION);
        db.execSQL("DROP TABLE "+this.TABLE_RECORDATORIO);

        onCreate(db);
    }

    public Cursor getdata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from TABLE_PRODUCTOS",null);
        return cursor;
    }

}
