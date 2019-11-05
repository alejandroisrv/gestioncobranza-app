package com.gestioncobranza.mainactivity.Rutas.Model;

import android.content.ContentValues;
import android.content.Context;
import android.provider.BaseColumns;

import com.gestioncobranza.mainactivity.Clientes.Model.Cliente;
import com.gestioncobranza.mainactivity.DB.DbManager;
import com.gestioncobranza.mainactivity.DB.TablaBase;
import com.gestioncobranza.mainactivity.Rutas.Rutas;

import java.util.ArrayList;

public class RutasRepositoryImpl extends DbManager implements Rutas.repository {

    private static final String TABLA = RutasEntry.TABLE;
    private static final String[] COLUMNAS = RutasEntry.COLUMNAS;
    private static final String TABLA_RUTA = ItemsRutasEntry.TABLE;
    private static final String[] COLUMNAS_RUTA = ItemsRutasEntry.COLUMNAS;
    private final ItemsRutasTable ItemsRutasTable;

    public RutasRepositoryImpl(Rutas.presenter rutasPresenter) {
        super(rutasPresenter.getView(),TABLA,COLUMNAS);
        this.ItemsRutasTable = new ItemsRutasTable(rutasPresenter.getView(),TABLA_RUTA,COLUMNAS_RUTA);
    }

    public void save (ArrayList<Cliente> clientes){
        ContentValues values = new ContentValues();

        for(int i = 0; i < clientes.size(); i++){

        }

        super.saveData(values);
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
    public void getItem(int id) {

    }

    @Override
    public void syncData() {

    }

    public class ItemsRutasTable extends DbManager {
        public ItemsRutasTable(Context context, String tabla, String[] columnas) {
            super(context, tabla, columnas);
        }
    }


    public static class RutasEntry extends TablaBase implements BaseColumns{
        public static String TABLE = "rutas";
        public static String[] COLUMNAS = new String[]{ COLUMNA_NOMBRE,COLUMNA_MUNICIPIO,COLUMNA_USUARIO_ID};
    }

    public static class ItemsRutasEntry extends TablaBase implements BaseColumns{

        public static String TABLE = "rutas_item";

        public static String COLUMNA_RUTA_ID = "ruta_id int not null";
        public static String COLUMNA_CLIENTE_ID = "cliente_id int not null";
        public static String COLUMNA_ORDEN = "orden int not null";
        public static String[] COLUMNAS = new String[]{ COLUMNA_RUTA_ID,COLUMNA_CLIENTE_ID,COLUMNA_ORDEN,COLUMNA_USUARIO_ID};
    }

}


