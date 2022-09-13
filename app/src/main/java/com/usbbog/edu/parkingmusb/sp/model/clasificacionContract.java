package com.usbbog.edu.parkingmusb.sp.model;


import android.provider.BaseColumns;

//ESQUEMA DE LA TB ROLES
// BaseColumns -> AGREGA COLUMNAS EXTRAS EN CASO DE NECESITARLAS (FACILITA EL MANTENIMIENTO DE LA DB)
public class clasificacionContract {

    //SAVE DB's TABLE COLUMNS
    public static abstract class clasificacionEntry implements BaseColumns{



        public static final String ID = "id";
        public static final String TIPO = "tipo";
        public static final String PERIODO = "periodo";
        public static final String VALOR = "valor";
    }

}
