package co.edu.usbbog.swm.model;

import android.provider.BaseColumns;

public class UsuariosContract {

    //SAVE DB's TABLE COLUMNS
    public static abstract class usersEntry implements BaseColumns {

        public static final String ID = "id";
        public static final String NOMBRE = "nombre";
        public static final String TELEFONO = "telefono";
        public static final String EMAIL = "email";
        public static final String USUARIO = "usuario";
        public static final String CLAVE = "clave";
        //public static final String ROL = "rol";

    }

}
