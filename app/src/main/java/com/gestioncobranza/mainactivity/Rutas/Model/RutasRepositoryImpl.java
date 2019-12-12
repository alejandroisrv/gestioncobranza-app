package com.gestioncobranza.mainactivity.Rutas.Model;

import android.content.ContentValues;
import android.content.Context;
import android.provider.BaseColumns;

import com.gestioncobranza.mainactivity.DB.DbManager;
import com.gestioncobranza.mainactivity.DB.RutaDB;
import com.gestioncobranza.mainactivity.DB.TablaBase;
import com.gestioncobranza.mainactivity.MainInterface;
import com.gestioncobranza.mainactivity.Rutas.Presenter.RutasPresenterImpl;
import com.gestioncobranza.mainactivity.Rutas.Rutas;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RutasRepositoryImpl extends DbManager implements Rutas.repository {

    private static final String TABLA = RutasEntry.TABLE;
    private static final String[] COLUMNAS = RutasEntry.COLUMNAS;
    private ItemsRutasTable ItemsRutasTable;

    public RutasRepositoryImpl(Rutas.presenter rutasPresenter) {
        super(rutasPresenter.getView(),TABLA,COLUMNAS);
        this.ItemsRutasTable = new ItemsRutasTable(rutasPresenter);
    }

    public void saveData (ArrayList<RutaDB.Ruta> rutas){


        String [] ids = new String[rutas.size()];

        for (int i = 0; i < rutas.size();i++) {
            ids[i] = String.valueOf(rutas.get(i).getId());
        }

        super.checkData(ids);


        for(int i = 0; i < rutas.size(); i++){
            ContentValues values = new ContentValues();
            RutaDB.Ruta ruta = rutas.get(i);

            values.put("_id",ruta.getId());
            values.put("nombre",ruta.getNombre());
            values.put("municipio_id", ruta.getMunicipioId());
            ItemsRutasTable.saveItems(ruta.getId(),ruta.getItems());

            super.saveData(values);
        }


    }

    @Override
    public void getDatos() {

    }

    @Override
    public void getDatos(String query) {

    }

    @Override
    public void getDatosApi(MainInterface.onResult onResult) {

        Call<RutaDB> call = apiService.getRutas("RT");
        call.enqueue(new Callback<RutaDB>() {
            @Override
            public void onResponse(Call<RutaDB> call, Response<RutaDB> response) {
                if(response.isSuccessful()){
                    saveData(response.body().getRT());
                }

                onResult.doAction();
            }

            @Override
            public void onFailure(Call<RutaDB> call, Throwable t) {

            }
        });

    }

    @Override
    public void getItem(int id) {

    }

    @Override
    public void syncData() {

    }

    public class ItemsRutasTable extends DbManager {
        public ItemsRutasTable(Rutas.presenter presenter) {
            super(presenter.getView(), ItemsRutasEntry.TABLE, ItemsRutasEntry.COLUMNAS);
        }

        public void saveItems(Integer id, ArrayList<RutaDB.Item> items){

            if(items == null) return;

            String [] ids = new String[items.size()];

            for (int i = 0; i < items.size();i++) {
                ids[i] = String.valueOf(items.get(i).getId());
            }

            super.checkData(ids);

            for (int i = 0; i < items.size(); i++){
                ContentValues values = new ContentValues();
                RutaDB.Item item = items.get(i);

                values.put("_id",item.getId());
                values.put("ruta_id",id);
                values.put("cliente_id",item.getClienteId());
                values.put("cliente_nombre",item.getClienteNombre());
                values.put("cliente_direccion",item.getClienteDireccion());
                values.put("orden", item.getOrden());

                super.saveData(values);
            }
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
        public static String COLUMNA_CLIENTE_NOMBRE = "cliente_nombre varchar(150) not null";
        public static String COLUMNA_CLIENTE_DIRECCION = "cliente_direccion varchar(150) not null";
        public static String COLUMNA_ORDEN = "orden int not null";

        public static String[] COLUMNAS = new String[]{ COLUMNA_RUTA_ID,COLUMNA_CLIENTE_ID,COLUMNA_CLIENTE_NOMBRE,COLUMNA_CLIENTE_DIRECCION,COLUMNA_ORDEN,COLUMNA_USUARIO_ID};

    }

}


