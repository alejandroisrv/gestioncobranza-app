package com.gestioncobranza.mainactivity.Clientes.Model;

import android.content.ContentValues;
import android.content.Context;
import android.provider.BaseColumns;

import com.gestioncobranza.mainactivity.DB.DbManager;

import java.util.ArrayList;
import java.util.Map;

public class ClienteRepository extends DbManager {
    private static final String TABLE_NAME = ClienteEntry.TABLE_NAME;
    private static final String[] COLUMNAS = ClienteEntry.COLUMNAS;

    public ClienteRepository(Context context) {
        super(context,TABLE_NAME,COLUMNAS);
    }

    public void save (ArrayList<Cliente> clientes){
        ContentValues values = new ContentValues();

        for ()


        super.saveData(values);
    }



    public static final class ClienteEntry implements BaseColumns {
        public static final String TABLE_NAME = "clientes";

        public static final String COLUMNA_NOMBRE = "nombre varchar(150) NOT NULL";
        public static final String COLUMNA_EMAIL = "email varchar(150) NOT NULL";
        public static final String COLUMNA_TELEFONO = "telefono varchar(150) NOT NULL";
        public static final String COLUMNA_CODIGO = "codigo varchar(150) NOT NULL";

        public static final String[] COLUMNAS = new String[]{COLUMNA_NOMBRE,COLUMNA_EMAIL,COLUMNA_TELEFONO,COLUMNA_CODIGO };

    }
}
