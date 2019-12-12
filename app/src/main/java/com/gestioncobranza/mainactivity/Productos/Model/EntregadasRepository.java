package com.gestioncobranza.mainactivity.Productos.Model;

import android.content.ContentValues;
import android.database.Cursor;
import android.provider.BaseColumns;

import com.gestioncobranza.mainactivity.DB.DbManager;
import com.gestioncobranza.mainactivity.DB.ProductoDB;
import com.gestioncobranza.mainactivity.DB.TablaBase;
import com.gestioncobranza.mainactivity.MainInterface;
import com.gestioncobranza.mainactivity.Productos.Producto;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EntregadasRepository extends DbManager implements Producto.entradasRepository {


    private static final String TABLA = EntregadasEntry.TABLA;
    private static final String[] COLUMNAS = EntregadasEntry.COLUMNAS;
    private final Producto.productosRepository productosRepository;
    private final Producto.presenter productosPresenter;

    public EntregadasRepository(Producto.presenter presenter) {
        super(presenter.getView(), TABLA, COLUMNAS);
        this.productosRepository = new ProductosRepository(presenter);
        this.productosPresenter = presenter;
    }

    @Override
    public void saveEntregas(ArrayList<ProductoDB.Entrega> entregas) {
            for (int i = 0;i < entregas.size(); i++){
                ContentValues values = new ContentValues();
                ProductoDB.Entrega entrega = entregas.get(i);

                values.put("vendedor_id",entrega.getVendedorId());
                values.put("comentario",entrega.getComentario());
                values.put("fecha",entrega.getCreatedAt());

                productosRepository.saveProductos(entrega.getItemProductoEntregas());

                super.saveData(values);
            }
    }

    @Override
    public void getEntregas() {
        Cursor cursor = super.getWritableDatabase().rawQuery("SELECT * FROM entradas",null);
        ArrayList<Entrega> entregas = new ArrayList<>();
        if(cursor != null) cursor.moveToFirst();


        while (!cursor.isAfterLast()) {
            Entrega entrega = new Entrega(getFieldI(cursor,"_id"),
                                          getField(cursor,"comentario"),
                                          getFieldI(cursor,"estado"),
                                          getField(cursor,"fecha"));
            entregas.add(entrega);
        }

        productosPresenter.showEntregas(entregas);

    }

    @Override
    public void getEntrega(int id) {
        Cursor cursor = super.getWritableDatabase().rawQuery("SELECT * FROM entradas WHERE _id = ? ",new String[]{ String.valueOf(id)});

        if(cursor != null) cursor.moveToFirst();

        Entrega entrega = new Entrega(getFieldI(cursor,"_id"),
                getField(cursor,"comentario"),
                getFieldI(cursor,"estado"),
                getField(cursor,"fecha"));

        productosPresenter.showEntrega(entrega);
    }

    @Override
    public void getDatos() {

    }

    @Override
    public void getDatos(String query) {

    }

    @Override
    public void getDatosApi(MainInterface.onResult onResult) {

        Call<ProductoDB> call = apiService.getProductos("PD");

        call.enqueue(new Callback<ProductoDB>() {
            @Override
            public void onResponse(Call<ProductoDB> call, Response<ProductoDB> response) {
                if (response.isSuccessful()){
                    saveEntregas(response.body().getPD());
                }
            }

            @Override
            public void onFailure(Call<ProductoDB> call, Throwable t) {

            }
        });
    }

    @Override
    public void getItem(int id) {

    }

    @Override
    public void syncData() {

    }


    public static class EntregadasEntry extends TablaBase implements BaseColumns {

        public static final String TABLA = "entregas";
        public static final String COLUMNA_VENDEDOR = "vendedor_id int not null";
        public static final String COLUMNA_COMENTARIO = "comentario int null default 0";
        public static final String COLUMNA_ESTADO = "estado int null default 0";
        public static final String COLUMNA_FECHA = "fecha varchar(150) not null";

        public static final String[] COLUMNAS = new String[]{ COLUMNA_USUARIO_ID,COLUMNA_VENDEDOR,COLUMNA_COMENTARIO,COLUMNA_ESTADO,COLUMNA_FECHA };

    }
}
