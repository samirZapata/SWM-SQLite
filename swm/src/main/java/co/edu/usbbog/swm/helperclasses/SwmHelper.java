package co.edu.usbbog.swm.helperclasses;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import co.edu.usbbog.swm.model.Clasificacion;
import co.edu.usbbog.swm.model.ClasificacionContract;

import java.util.ArrayList;

public class SwmHelper {

    private static final String DATABASE_NAME = "swm.db";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_TABLE = "clasificacion";

    private DBHelper helper;
    private Context context;
    SQLiteDatabase DATABASE;
    Cursor c;

    public SwmHelper(Context context){
        super();
        this.context = context;
    }

    //TO OPEN DB
    public SwmHelper open() throws SQLException {
        this.helper = new DBHelper(context);
        this.DATABASE = this.helper.getWritableDatabase();
        return this;
    }

    //TO CLOSE DB
    public void close(){
        this.helper.close();
    }

    //TO READ DB DATA
    public ArrayList<Clasificacion> getClasificacion(){
        //RECEIVE COLUMNS, QUERY THEN WE HAVE TO ITERATE THESE RESULTS.

        //COLUMNS
        String[] columns = new String[]{
                ClasificacionContract.clasificacionEntry.ID
                /*ClasificacionContract.clasificacionEntry.TIPO,
                ClasificacionContract.clasificacionEntry.PERIODO,
                ClasificacionContract.clasificacionEntry.VALOR*/
        };
        Log.i("helper", columns[0]);
        //QUERY
        c = this.DATABASE.query(DATABASE_TABLE, columns, null,null, null, null, null);
        //RESULT
        ArrayList<Clasificacion> results = new ArrayList<>();
        //i -> ANDROID's INTERN DATA
        int iID = c.getColumnIndex(ClasificacionContract.clasificacionEntry.ID);
        int iTIPO = c.getColumnIndex(ClasificacionContract.clasificacionEntry.TIPO);
        int iPERIODO = c.getColumnIndex(ClasificacionContract.clasificacionEntry.PERIODO);
        int iVALOR = c.getColumnIndex(ClasificacionContract.clasificacionEntry.VALOR);

        //ITERATE LIST RESULTS
        //WHILE THE CURSOR ISN'T OVER MOVE TO NEXT
        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
            int ID = c.getInt(iID);
            String TIPO = c.getString(iTIPO);
            String PERIODO = c.getString(iPERIODO);
            String VALOR = c.getString(iVALOR);

            //GENERATE CONSTRUCTOR's OBJECT
            Clasificacion clasificacion = new Clasificacion(ID, TIPO, PERIODO, VALOR);
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
                    + ClasificacionContract.clasificacionEntry.ID     + "INT PRIMARY KEY NOT NULL," //BECAUSE THE ANDROID's FRAMEWORK USES THIS REFERENCE IN OTHERS PROCCESS
                    + ClasificacionContract.clasificacionEntry.TIPO    + "VARCHAR NOT NULL,"
                    + ClasificacionContract.clasificacionEntry.PERIODO + "VARCHAR NOT NULL,"
                    + ClasificacionContract.clasificacionEntry.VALOR   + "VARCHAR NOT NULL);";
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
