package co.edu.usbbog.swm.helperclasses;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConexionSQLite extends SQLiteOpenHelper {

    //CLASIFICATION'S TABLE
    private final String tableClasificacion = "CREATE TABLE clasification(id INTEGER PRIMARY KEY AUTOINCREMENT, tipo TEXT, periodo TEXT, valor DOUBLE)";
    //USER'S TABLE
    private final String tblUsers = "CREATE TABLE users(id INTGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, telefono TEXT, email TEXT, usuario TEXT, clave TEXT, rol INTEGER)";
    //INCOME TABLE
    private final String tblIncome = "CREATE TABLE income(id INTEGER PRIMARY KEY AUTOINCREMENT, valor DOUBLE)";

    public ConexionSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //ALL I WANT TO CREATE WHEN WE INVOKE THIS CLASS
    @Override
    public void onCreate(SQLiteDatabase db) {
        //CREATE FIRST TABLE
        db.execSQL(tableClasificacion);
        //CREATE SECOND TABLE
        db.execSQL(tblIncome);
        //CREATE THIRD TABLE
        //db.execSQL(tblUsers);

    }

    //WHEN WE MAKE CHANGES IN SOME TABLE
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
