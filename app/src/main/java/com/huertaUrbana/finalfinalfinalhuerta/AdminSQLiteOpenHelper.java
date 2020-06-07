package com.huertaUrbana.finalfinalfinalhuerta;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {


    public AdminSQLiteOpenHelper(Context context, String nombre, CursorFactory factory, int version) {
        super(context, nombre, factory, version);
    }
    @Override public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table vegetales(codigo integer primary key, nombre text, foto)");
        db.execSQL("create table codigoQR(codigo integer primary key AUTOINCREMENT, nombreQR text, fechaPlantacion)");
    }
    @Override public void onUpgrade(SQLiteDatabase db, int versionAnte, int versionNue){
        db.execSQL("drop table if exists vegetales");
        db.execSQL("create table vegetales(codigo integer primary key, nombre text, fecha, foto)");
        db.execSQL(("drop table if exists codigoQR"));
        db.execSQL("create table codigoQR(codigo integer primary key AUTOINCREMENT, nombreQR text, fechaPlantacion)");
    }
    

}

