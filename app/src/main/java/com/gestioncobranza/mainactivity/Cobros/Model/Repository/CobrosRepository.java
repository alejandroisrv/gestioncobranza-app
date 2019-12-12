package com.gestioncobranza.mainactivity.Cobros.Model.Repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.provider.BaseColumns;

import com.gestioncobranza.mainactivity.Cobros.Cobros;
import com.gestioncobranza.mainactivity.Cobros.Model.Cobro;
import com.gestioncobranza.mainactivity.Cobros.Model.CobroResultado;
import com.gestioncobranza.mainactivity.DB.CobroDB;
import com.gestioncobranza.mainactivity.DB.DbManager;
import com.gestioncobranza.mainactivity.DB.TablaBase;
import com.gestioncobranza.mainactivity.MainInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CobrosRepository extends DbManager implements Cobros.repository{


    private static final String TABLA = CobrosEntry.TABLE;
    private static final String[] COLUMNAS = CobrosEntry.COLUMNAS ;
    private final Cobros.presenter cobrosPresenter;
    private final CobrosItemR cobrosItemR;

    public CobrosRepository(Cobros.presenter cobrosPresenter) {
        super(cobrosPresenter.getView(),TABLA,COLUMNAS);
        this.cobrosPresenter = cobrosPresenter;
        this.cobrosItemR = new CobrosItemR();
    }

    @Override
    public void saveCobros(ArrayList<CobroDB.Cobro> cobros) {
        for (int i = 0; i < cobros.size(); i++) {
            ContentValues values = new ContentValues();
            CobroDB.Cobro cobro = cobros.get(i);

            values.put("_id",cobro.getId());
            values.put("ruta_id",cobro.getRutaId());
            values.put("fecha_inicio",cobro.getFechaInicio());
            values.put("comision",cobro.getComision());

            if(cobro.getCobroItems() != null ) cobrosItemR.saveItems(cobro.getCobroItems());

            super.saveData(values);
        }
    }

    @Override
    public void sendResult(CobroResultado cobroResultado) {

    }

    @Override
    public void getDatos() {

    }

    @Override
    public void getDatos(String query) {
        Cursor cursor = super.getReadableDatabase().rawQuery("SELECT cobros.*,ruta.nombre as rutaNombre FROM cobros INNER JOIN rutas ON rutas.id = cobros.ruta_id",null);
        ArrayList<Cobro> cobros = new ArrayList<>();
        if( cursor != null) cursor.moveToFirst();

        while (!cursor.isAfterLast()){


            Cobro cobro = new Cobro(getFieldI(cursor,"_id"),
                                    getField(cursor,"rutaNombre"),
                                    getFieldI(cursor,"estado"),
                                    getField(cursor,"fecha_inicio"),
                                    cobrosItemR.getItemsCobro(getFieldI(cursor,"_id")));

            cobros.add(cobro);
            cursor.moveToNext();
        }

        cobrosPresenter.showData(cobros);
    }

    @Override
    public void getDatosApi(MainInterface.onResult onResult) {
        Call<CobroDB> call = apiService.getCobros("CB");

        call.enqueue(new Callback<CobroDB>() {
            @Override
            public void onResponse(Call<CobroDB> call, Response<CobroDB> response) {
                if(response.isSuccessful()){
                    if(response.body().getCb().size() > 0){
                        saveCobros(response.body().getCb());
                    }
                }
            }

            @Override
            public void onFailure(Call<CobroDB> call, Throwable t) {

            }
        });
    }

    @Override
    public void getItem(int id) {

    }

    @Override
    public void syncData() {

    }

    public class CobrosItemR extends DbManager implements Cobros.itemsCobroRepository {
        public CobrosItemR() {
            super(cobrosPresenter.getView(),CobrosItemEntry.TABLE, CobrosItemEntry.COLUMNAS );
        }

        @Override
        public void saveItems(ArrayList<CobroDB.CobroItem> items) {
            for (int i = 0; i < items.size(); i++){

                ContentValues values = new ContentValues();
                CobroDB.CobroItem item = items.get(i);

                values.put("_id",item.getId());
                values.put("ruta_item_id",item.getRutaItemId());
                values.put("venta_id",item.getId());
                values.put("monto",item.getMonto());
                values.put("comision",item.getComision());
                values.put("fecha_culminacion",item.getFechaCulminacion());

                super.saveData(values);
            }
        }

        @Override
        public ArrayList<Cobro.ItemCobro> getItemsCobro(int id) {
           ArrayList<Cobro.ItemCobro> items = new ArrayList<>();

           Cursor cursor = super.getReadableDatabase().rawQuery(
                   "SELECT cobros_item.*,rutas_item.cliente_nombre, rutas_item.cliente_direccion,rutas_item.orden  FROM cobros " +
                       "INNER JOIN rutas_item ON  rutas_item._id = cobros_item.ruta_item_id WHERE cobros_item.cobro_id = ?",
                   new String[]{String.valueOf(id)});

           if(cursor != null) cursor.moveToFirst();

           while(!cursor.isAfterLast()){

               Cobro.ItemCobro itemCobro = new Cobro.ItemCobro(getFieldI(cursor,"cobro_id"),
                       getField(cursor,"cliente_nombre"),
                       getField(cursor,"cliente_direccion"),
                       getField(cursor,"monto"),
                       getFieldI(cursor,"estado"),
                       getField(cursor,"comision"),
                       getField(cursor,"observacion"));

               items.add(itemCobro);
               cursor.moveToNext();
           }

            return items;
        }
    }

    public static class CobrosEntry extends TablaBase implements BaseColumns{
        public static final String TABLE ="cobros";

        public static final String COLUMNA_RUTA_ID ="ruta_id int not null";
        public static final String COLUMNA_ESTADO ="estado int null default 0";
        public static final String COLUMNA_COMISION ="comision varchar(50) null";
        public static final String COLUMNA_FECHA_INICIO = "fecha_inicio varchar(50) null";
        public static final String COLUMNA_FECHA_CULMINACION = "fecha_culminacion varchar(50) null";

        public static final String[] COLUMNAS = new String[]{COLUMNA_USUARIO_ID,COLUMNA_RUTA_ID,COLUMNA_ESTADO,COLUMNA_COMISION,COLUMNA_FECHA_INICIO,COLUMNA_FECHA_CULMINACION};
    }

    public static class CobrosItemEntry {
        public static final String TABLE = "cobros_item";

        public static final String COLUMNA_COBRO_ID = "cobro_id int(10) not null";
        public static final String COLUMNA_RUTA_ITEM_ID = "ruta_item_id int(10) not null";
        public static final String COLUMNA_VENTA_ID = "venta_id int(10) not null";
        public static final String COLUMNA_MONTO = "monto varchar(50) not null";
        public static final String COLUMNA_COMISION = "comision varchar(50) not null";
        public static final String COLUMNA_ESTADO = "estado int null default 0";
        public static final String COLUMNA_OBSERVACION = "observacion varchar(50) null";
        public static final String COLUMNA_FECHA_CULMINACION = "fecha_culminacion varchar(50) null";

        public static final String[] COLUMNAS = new String[]{COLUMNA_COBRO_ID, COLUMNA_RUTA_ITEM_ID, COLUMNA_VENTA_ID, COLUMNA_MONTO, COLUMNA_ESTADO, COLUMNA_OBSERVACION, COLUMNA_FECHA_CULMINACION,COLUMNA_COMISION};

    }

}
