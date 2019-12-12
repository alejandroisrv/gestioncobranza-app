package com.gestioncobranza.mainactivity.Clientes.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.provider.BaseColumns;

import com.gestioncobranza.mainactivity.Clientes.Clientes;
import com.gestioncobranza.mainactivity.DB.ClienteDB;
import com.gestioncobranza.mainactivity.DB.DbManager;
import com.gestioncobranza.mainactivity.DB.TablaBase;

public class MunicipiosRepository extends DbManager {

    public MunicipiosRepository(Clientes.presenter clientesPresenter) {
        super(clientesPresenter.getView(), MunicipioEntry.TABLE_NAME,MunicipioEntry.COLUMNAS);
    }

    public void saveMunicipio(ClienteDB.Municipio municipio){

            ContentValues values = new ContentValues();
            values.put("_id",municipio.getId());
            values.put("nombre",municipio.getMunicipio());

            super.saveData(values);
    }

    public static final class MunicipioEntry extends TablaBase implements BaseColumns {
        public static final String TABLE_NAME = "municipios";

        public static final String COLUMNA_NOMBRE = "nombre varchar(250) NOT NULL";

        public static final String[] COLUMNAS = new String[]{ COLUMNA_USUARIO_ID,COLUMNA_NOMBRE};
    }
}
