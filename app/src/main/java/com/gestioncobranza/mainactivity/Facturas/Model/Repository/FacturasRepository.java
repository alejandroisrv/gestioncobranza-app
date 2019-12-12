package com.gestioncobranza.mainactivity.Facturas.Model.Repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.provider.BaseColumns;

import com.gestioncobranza.mainactivity.DB.DbManager;
import com.gestioncobranza.mainactivity.DB.FacturaDB;
import com.gestioncobranza.mainactivity.DB.TablaBase;

import com.gestioncobranza.mainactivity.Facturas.Factura;
import com.gestioncobranza.mainactivity.Facturas.Model.ProductoFactura;
import com.gestioncobranza.mainactivity.Facturas.Model.Venta;
import com.gestioncobranza.mainactivity.MainInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FacturasRepository extends DbManager implements Factura.repository {

    private final Factura.presenter facturasPresenter;
    private final Factura.abonosRepositor abonosRepository;
    private final Factura.productosFacturasRepository productosFacturasR;

    public FacturasRepository(Factura.presenter facturasPresenter) {
        super(facturasPresenter.getView(),FacturasEntry.TABLE,FacturasEntry.COLUMNAS);
        this.facturasPresenter = facturasPresenter;
        this.abonosRepository = new AbonosFacturasRepository(facturasPresenter);
        this.productosFacturasR = new ProductoFacturasRepository(facturasPresenter);
    }

    @Override
    public void saveFacturas(ArrayList<FacturaDB.Factura> facturas) {
            for (int i = 0; i < facturas.size();i++) {
                ContentValues values = new ContentValues();
                FacturaDB.Factura factura  = facturas.get(i);
                values.put("_id",factura.getId());
                values.put("cod",factura.getCod());
                values.put("user_id",factura.getCod());
                values.put("cliente_id",factura.getCod());
                values.put("tipo_venta",factura.getTipoVenta());
                values.put("abono",factura.getAbono());
                values.put("descuento",factura.getDescuento());
                values.put("periodo_pago",factura.getPeriodoPago());
                values.put("cuotas",factura.getCuotas());
                values.put("total",factura.getTotal());
                values.put("fecha_creacion",factura.getCreatedAt());
                productosFacturasR.saveProductosFactura(factura.getProductosVenta());
                abonosRepository.saveAbonos(factura.getAbonos());
                super.saveData(values);
            }
    }

    @Override
    public void getDatos() {

    }


    @Override
    public void getDatos(String query) {
        String sql = "SELECT ventas.*,clientes.nombre as cliente_nombre FROM ventas " +
                     "INNER JOIN clientes ON clientes._id = ventas.cliente_id WHERE cod = ?";

        Cursor cursor = super.getReadableDatabase().rawQuery(sql,new String[]{ query + "%"});

        ArrayList<Venta> ventas = new ArrayList<>();

        if(cursor != null ) cursor.moveToFirst();

        while (!cursor.isAfterLast()){

            Venta venta = new Venta(
                        getFieldI(cursor,"_id"),
                        getField(cursor,"cod"),
                        getFieldI(cursor,"user_id"),
                        getFieldI(cursor,"cliente_id"),
                        getField(cursor,"vendedor"),
                        getField(cursor,"cliente_nombre"),
                        getField(cursor,"tipo_venta"),
                        getField(cursor,"abono"),
                        getField(cursor,"descuento"),
                        getField(cursor,"periodo_pago"),
                        getField(cursor,"cuotas"),
                        getField(cursor,"total"),
                        productoFacturas(getFieldI(cursor,"_id")));

            ventas.add(venta);

            cursor.moveToNext();
        }

        facturasPresenter.showVentas(ventas);
    }
    @Override
    public void getDatosApi(MainInterface.onResult onResult) {
        Call<FacturaDB> call = apiService.getFacturas("VT");


        call.enqueue(new Callback<FacturaDB>() {
            @Override
            public void onResponse(Call<FacturaDB> call, Response<FacturaDB> response) {
                if (response.isSuccessful()){
                    saveFacturas(response.body().getVT());
                }
            }

            @Override
            public void onFailure(Call<FacturaDB> call, Throwable t) {

            }
        });

        onResult.doAction();
    }

    @Override
    public void getItem(int id) {

    }

    @Override
    public void syncData() {

    }

    public ArrayList<ProductoFactura> productoFacturas (int venta_id){
            Cursor cursor = super.getReadableDatabase().rawQuery("SELECT * FROM productos_ventas WHERE venta_id = ?", new String[]{( String.valueOf(venta_id))});
            ArrayList<ProductoFactura> productoFacturas = new ArrayList<>();

            if(cursor != null) cursor.moveToFirst();

            while (!cursor.isAfterLast()){
                ProductoFactura productoFactura = new ProductoFactura(getFieldI(cursor,"_id"),getField(cursor,"producto_nombre"),getField(cursor,"producto_precio"),getFieldI(cursor,"cantidad"));
                productoFacturas.add(productoFactura);
                cursor.moveToNext();
            }

            return productoFacturas;
    }

    public ArrayList<Abono> abonos (int venta_id,String cliente){
        ArrayList<Abono> abonos = new ArrayList<>();

        Cursor cursor = super.getReadableDatabase().rawQuery("SELECT pagos_clientes.*,clientes.nombre AS cliente FROM pagos_clientes INNER JOIN clientes ON clientes._id = pagos_clientes.cliente_id WHERE pagos_clientes.venta_id = ? OR clientes.nombre = ?", new String[]{ String.valueOf(venta_id),"%"+ cliente +"%"});
        if(cursor != null ) cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            Abono abono = new Abono(getFieldI(cursor,"_id"),getField(cursor,"cliente"),getField(cursor,"monto"),getField(cursor,"saldo"),getField(cursor,"fecha"));
            abonos.add(abono);
            cursor.moveToFirst();
        }

        return abonos;
    }

    public static class FacturasEntry extends TablaBase implements BaseColumns {
        public static final String TABLE = "ventas";
        public static final String COLUMNA_COD = "cod int not null";
        public static final String COLUMNA_USER_ID = "user_id int not null";
        public static final String COLUMNA_CLIENTE_ID = "cliente_id int not null";
        public static final String COLUMNA_TIPO_VENTA = "tipo_venta varchar(250) not null";
        public static final String COLUMNA_ABONO = "abono varchar(50) null default '0.0' ";
        public static final String COLUMNA_DESCUENTO = "descuento varchar(50) null default '0.0' ";
        public static final String COLUMNA_PERIODO_PAGO = "periodo_pago varchar(50) not null";
        public static final String COLUMNA_CUOTAS = "cuotas int not null";
        public static final String COLUMNA_ESTADO = "estado int null default 0";
        public static final String COLUMNA_MONTO = "total varchar(50) not null";
        public static final String COLUMNA_FECHA_CREACION = "fecha_creacion varchar(50) not null";

        public static final String[] COLUMNAS = new String[]{ COLUMNA_USUARIO_ID,
                COLUMNA_COD,COLUMNA_USER_ID,COLUMNA_CLIENTE_ID,COLUMNA_TIPO_VENTA,COLUMNA_ABONO,
                COLUMNA_DESCUENTO,
                COLUMNA_PERIODO_PAGO,
                COLUMNA_CUOTAS,
                COLUMNA_ESTADO,
                COLUMNA_MONTO,
                COLUMNA_FECHA_CREACION};
    }

}
