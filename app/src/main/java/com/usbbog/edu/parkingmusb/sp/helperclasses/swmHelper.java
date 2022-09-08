package com.usbbog.edu.parkingmusb.sp.helperclasses;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class swmHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "swm.db";
    private static final int DATABASE_VERSION = 1;

    public swmHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //SE INVOCA AUTOMATICAMENTE AL CREAR UNA INSTANCIA DEL HELPER
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    //SI LA BD LLEGA A TENER UNA VERSION MAYOR INVOCAMOS ESTE METODO
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
