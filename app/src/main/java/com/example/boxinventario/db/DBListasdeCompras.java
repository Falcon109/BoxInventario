package com.example.boxinventario.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.boxinventario.entidades.Producto;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DBListasdeCompras extends DBHelper{


    private Context context;
    private SQLiteDatabase db;

    public DBListasdeCompras(@Nullable Context context){
        super(context);
        this.context = context;
    }

}
