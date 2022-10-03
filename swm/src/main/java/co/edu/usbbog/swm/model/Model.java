package co.edu.usbbog.swm.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import co.edu.usbbog.swm.helperclasses.ConexionSQLite;

public class Model {


    //TO GET THE DB CONECTION
    public SQLiteDatabase getConn(Context context) {
        ConexionSQLite conn = new ConexionSQLite(context, "swmdb", null, 1);
        //RETURN WRITABLE OBJECT
        SQLiteDatabase db = conn.getWritableDatabase();
        return db;
    }


    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------
                                                                      CLASIFICATION
    * -----------------------------------------------------------------------------------------------------------------------------------------------------------*/

    //CLASIFICATION INSERT METHOD
    public int insertClasification(Context context, Clasificacion dto) {
        //WHEN RES IS EQUAL TO 0 ISN'T AN INSERT, BUT WHEN IS 1 THIS BECOME AN INSERT
        String sql = "INSERT INTO clasification (tipo, periodo, valor) VALUES ('" + dto.getTipo() + "','" + dto.getPeriodo() + "','" + dto.getValor() + "')";
        SQLiteDatabase db = this.getConn(context);
        try {
            db.execSQL(sql);
            Log.i("YES", "The insertion was correct");
        } catch (SQLException e) {
            Log.i("Insert", e.getMessage() + "");
            return 0;
        }
        return 1;
    }

    public String queryClasification(Context context, Clasificacion dto) {
        //WHEN RES IS EQUAL TO 0 ISN'T AN INSERT, BUT WHEN IS 1 THIS BECOME AN INSERT
        String sql = "SELECT * FROM clasification";
        SQLiteDatabase db = this.getConn(context);
        String salida = "";
        try {
            Cursor c = db.rawQuery(sql, null);

            int iID = c.getColumnIndex(ClasificacionContract.clasificacionEntry.ID);
            int iTIPO = c.getColumnIndex(ClasificacionContract.clasificacionEntry.TIPO);
            int iPERIODO = c.getColumnIndex(ClasificacionContract.clasificacionEntry.PERIODO);
            int iVALOR = c.getColumnIndex(ClasificacionContract.clasificacionEntry.VALOR);
            Log.i("RV", c.toString());


            for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
                salida += "ID: " + c.getString(iID)
                        + " tipo: " + c.getString(iTIPO)
                        + " periodo: " + c.getString(iPERIODO)
                        + " valor: " + c.getString(iVALOR) + '\n';

            }
            c.close();
            Log.i("YES", "The insertion was correct");
        } catch (SQLException e) {
            Log.i("Insert", e.getMessage() + "");
        }
        return salida;
    }

    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------
                                                                      INCOMES
    * -----------------------------------------------------------------------------------------------------------------------------------------------------------*/

    //CLASIFICATION INSERT METHOD
    public int insertIncome(Context context, Ingresos dto) {
        //WHEN RES IS EQUAL TO 0 ISN'T AN INSERT, BUT WHEN IS 1 THIS BECOME AN INSERT
        String sql = "INSERT INTO income (valor) VALUES ('" + dto.getValor() + "')";
        SQLiteDatabase db = this.getConn(context);
        try {
            db.execSQL(sql);
            Log.i("YES", "The insertion was correct");
        } catch (SQLException e) {
            Log.i("Insert", e.getMessage() + "");
            return 0;
        }
        return 1;
    }


    @SuppressLint("Range")
    public String queryIncome(Context context, Ingresos dto) {
        //WHEN RES IS EQUAL TO 0 ISN'T AN INSERT, BUT WHEN IS 1 THIS BECOME AN INSERT
        String sql = "SELECT valor FROM income";
        SQLiteDatabase db = this.getConn(context);
        String salida = "";
        try {
            Cursor c = db.rawQuery(sql, null);
            /*int v[] = new int[c.getCount()];
            int i = 0;
            if (c.getCount() > 0){
                c.moveToFirst();
                do {
                    v[i] = c.getInt(c.getColumnIndex("valor"));
                    i++;
                }while (c.moveToNext());
                c.close();
            }*/

            int iVALOR = c.getColumnIndex(IngresosContract.incomeEntry.VALOR);
            for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
                salida += c.getString(iVALOR);
                        //+ " valor: " + c.getString(iVALOR) + '\n';
                Log.i("SALIDA", salida.toString());
            }
            c.close();

        } catch (SQLException e) {
            Log.i("SELECT", e.getMessage() + "");
        }
        return salida;
    }

}
