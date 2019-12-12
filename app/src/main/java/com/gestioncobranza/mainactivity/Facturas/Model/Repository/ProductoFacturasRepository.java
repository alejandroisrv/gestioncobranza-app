package com.gestioncobranza.mainactivity.Facturas.Model.Repository;

import android.content.ContentValues;
import android.provider.BaseColumns;

import com.gestioncobranza.mainactivity.DB.DbManager;
import com.gestioncobranza.mainactivity.DB.TablaBase;
import com.gestioncobranza.mainactivity.Facturas.Factura;
import com.gestioncobranza.mainactivity.Facturas.Model.ProductoFactura;

import java.util.ArrayList;

public class ProductoFacturasRepository extends DbManager implements Factura.productosFacturasRepository {

    private static final String TABLA = ProductosFacturasEntry.TABLE;
    private static final String[] COLUMNAS = ProductosFacturasEntry.COLUMNAS;

    public ProductoFacturasRepository(Factura.presenter facturasPresenter) {
        super(facturasPresenter.getView(), TABLA, COLUMNAS);
    }

    public void saveProductosFactura(ArrayList<ProductoFactura> productoFacturas){
        for (int i = 0; i < productoFacturas.size(); i++){
            ContentValues values = new ContentValues();
            ProductoFactura productoFactura = productoFacturas.get(i);
            values.put("venta_id",productoFactura.getVentaId());
            values.put("producto_nombre",productoFactura.getProducto());
            values.put("producto_precio",productoFactura.getPrecio());
            values.put("cantidad",productoFactura.getCantidad());
            super.insert(values);
        }
    }

    public static class ProductosFacturasEntry extends TablaBase implements BaseColumns {
        public static final String TABLE = "productos_ventas";
        public static final String COLUMNA_USER_ID = "venta_id int not null";
        public static final String COLUMNA_PRODUCTO_NOMBRE = "producto_nombre varchar(250) not null";
        public static final String COLUMNA_MONTO = "producto_precio varchar(50) not null";
        public static final String COLUMNA_CANTIDAD = "cantidad int not null";
        public static final String[] COLUMNAS = new String[]{COLUMNA_USER_ID,COLUMNA_PRODUCTO_NOMBRE,COLUMNA_MONTO,COLUMNA_CANTIDAD,};
    }
}

