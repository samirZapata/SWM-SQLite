package com.usbbog.edu.parkingmusb.sp.helperclasses;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;

import com.usbbog.edu.parkingmusb.sp.model.clasificacion;
import com.usbbog.edu.parkingmusb.sp.model.clasificacionContract;

import java.util.ArrayList;

public class swmHelper {

    private static final String DATABASE_NAME = "swm.db";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_TABLE = "clasificacion";

    private DBHelper helper;
    private Context context;
    SQLiteDatabase DATABASE;
    Cursor c;

    public swmHelper(Context context){
        super();
        this.context = context;
    }

    //TO OPEN DB
    public swmHelper open() throws SQLException {
        this.helper = new DBHelper(context);
        this.DATABASE = this.helper.getWritableDatabase();
        return this;
    }

    //TO CLOSE DB
    public void close(){
        this.helper.close();
    }

    //TO READ DB DATA
    public ArrayList<clasificacion> getClasificacion(){
        //RECEIVE COLUMNS, QUERY THEN WE HAVE TO ITERATE THESE RESULTS.

        //COLUMNS
        String[] columns = new String[]{
                clasificacionContract.clasificacionEntry.ID
                /*clasificacionContract.clasificacionEntry.TIPO,
                clasificacionContract.clasificacionEntry.PERIODO,
                clasificacionContract.clasificacionEntry.VALOR*/
        };
        Log.i("helper", columns[0]);
        //QUERY
        c = this.DATABASE.query(DATABASE_TABLE, columns, null,null, null, null, null);
        //RESULT
        ArrayList<clasificacion> results = new ArrayList<>();
        //i -> ANDROID's INTERN DATA
        int iID = c.getColumnIndex(clasificacionContract.clasificacionEntry.ID);
        int iTIPO = c.getColumnIndex(clasificacionContract.clasificacionEntry.TIPO);
        int iPERIODO = c.getColumnIndex(clasificacionContract.clasificacionEntry.PERIODO);
        int iVALOR = c.getColumnIndex(clasificacionContract.clasificacionEntry.VALOR);

        //ITERATE LIST RESULTS
        //WHILE THE CURSOR ISN'T OVER MOVE TO NEXT
        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
            int ID = c.getInt(iID);
            String TIPO = c.getString(iTIPO);
            String PERIODO = c.getString(iPERIODO);
            String VALOR = c.getString(iVALOR);

            //GENERATE CONSTRUCTOR's OBJECT
            clasificacion clasificacion = new clasificacion(ID, TIPO, PERIODO, VALOR);
            results.add(clasificacion);
        }
        c.close();
        return results;
    }

    //TO CREATE DB
    private class DBHelper extends SQLiteOpenHelper{

        //Context context -> PROVIDES ACITION CONSTROLS TO HELPER
        public DBHelper(@Nullable Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        //AUTOMATICALLY CALLED ON CREATION HELPER's INSTANCE
        @Override
        public void onCreate(SQLiteDatabase DB) {

            /*String sql = "CREATE TABLE IF NOT EXISTS "
                    + DATABASE_TABLE + "("
                    + clasificacionContract.clasificacionEntry.ID     + "INT PRIMARY KEY NOT NULL," //BECAUSE THE ANDROID's FRAMEWORK USES THIS REFERENCE IN OTHERS PROCCESS
                    + clasificacionContract.clasificacionEntry.TIPO    + "VARCHAR NOT NULL,"
                    + clasificacionContract.clasificacionEntry.PERIODO + "VARCHAR NOT NULL,"
                    + clasificacionContract.clasificacionEntry.VALOR   + "VARCHAR NOT NULL);";
            DB.execSQL(sql);*/


        }

        //SI LA BD LLEGA A TENER UNA VERSION MAYOR INVOCAMOS ESTE METODO
        @Override
        public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
            DB.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            onCreate(DB);
        }
    }




}
