package com.gestioncobranza.mainactivity.Clientes.Model;

import android.content.ContentValues;
import android.provider.BaseColumns;
import com.gestioncobranza.mainactivity.Clientes.Clientes;
import com.gestioncobranza.mainactivity.DB.DbManager;
import com.gestioncobranza.mainactivity.DB.TablaBase;

import java.util.ArrayList;

public class ClientesRepository extends DbManager implements Clientes.repository {

    private static final String TABLE_NAME = ClienteEntry.TABLE_NAME;
    private static final String[] COLUMNAS = ClienteEntry.COLUMNAS;

    public ClientesRepository(Clientes.presenter clientesPresenter) {
        super(clientesPresenter.getView(),TABLE_NAME,COLUMNAS);
    }

    public void save (ArrayList<Cliente> clientes){
        ContentValues values = new ContentValues();

        for(int i = 0; i < clientes.size(); i++){

        }

        super.saveData(values);
    }

    @Override
    public void addCliente(Cliente cliente) {

    }

    @Override
    public void getDatos() {

    }

    @Override
    public void getDatos(String query) {

    }

    @Override
    public void getDatosApi() {

    }

    @Override
    public void syncData() {

    }

    @Override
    public void getItem(int id) {

    }

    public static final class ClienteEntry extends TablaBase implements BaseColumns {
        public static final String TABLE_NAME = "clientes";

        public static final String COLUMNA_COD = "cod int(10) NOT NULL";
        public static final String COLUMNA_CEDULA = "cedula varchar(150) NOT NULL";
        public static final String COLUMNA_DIRECCION = "nombre varchar(150) NOT NULL";
        public static final String COLUMNA_EMAIL = "email varchar(150) NOT NULL";
        public static final String COLUMNA_TELEFONO = "telefono varchar(150) NOT NULL";
        public static final String COLUMNA_RUTA_ID = "cod int(10) NOT NULL";

        public static final String[] COLUMNAS = new String[]{COLUMNA_COD,COLUMNA_USUARIO_ID,COLUMNA_NOMBRE,COLUMNA_CEDULA,COLUMNA_DIRECCION,COLUMNA_EMAIL,COLUMNA_TELEFONO,COLUMNA_MUNICIPIO,COLUMNA_RUTA_ID };
    }
}
