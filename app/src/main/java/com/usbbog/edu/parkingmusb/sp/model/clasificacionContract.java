package com.usbbog.edu.parkingmusb.sp.model;


import android.provider.BaseColumns;

//ESQUEMA DE LA TB ROLES
// BaseColumns -> AGREGA COLUMNAS EXTRAS EN CASO DE NECESITARLAS (FACILITA EL MANTENIMIENTO DE LA DB)
public class rolesContract{

    //SAVE DB's TABLE COLUMNS
    public static abstract class rolesEntry implements BaseColumns{

        private static final String DATABASE_TABLE = "clasificacion";

        private static final int ID = Integer.parseInt("id");
        private static final String TIPO = "tipo";
        private static final String PERIODO = "periodo";
        private static final String VALOR = "periodo";
    }

}
