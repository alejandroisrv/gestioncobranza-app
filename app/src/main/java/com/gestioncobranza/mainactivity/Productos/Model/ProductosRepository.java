package com.gestioncobranza.mainactivity.Productos.Model;

import android.content.ContentValues;
import android.database.Cursor;
import android.provider.BaseColumns;

import com.gestioncobranza.mainactivity.DB.DbManager;
import com.gestioncobranza.mainactivity.DB.ProductoDB;
import com.gestioncobranza.mainactivity.DB.TablaBase;
import com.gestioncobranza.mainactivity.Productos.Producto;

import java.util.ArrayList;

public class ProductosRepository extends DbManager implements Producto.productosRepository {

    private Producto.presenter productosPresenter;

    public ProductosRepository(Producto.presenter productosPresenter) {
        super(productosPresenter.getView(),ProductosEntry.TABLA,ProductosEntry.COLUMNAS);
        this.productosPresenter = productosPresenter;
    }

    @Override
    public void saveProductos(ArrayList<ProductoDB.ItemProductoEntrega> productos) {

        for (int i = 0; i < productos.size(); i++ ){

            ContentValues values = new ContentValues();
            ProductoDB.ItemProductoEntrega itemProductoEntrega = productos.get(i);

            values.put("_id",itemProductoEntrega.getProducto().getId());
            values.put("nombre",itemProductoEntrega.getProducto().getNombre());
            values.put("descripcion",itemProductoEntrega.getProducto().getDescripcion());
            values.put("precio_credito",itemProductoEntrega.getProducto().getPrecioCredito());
            values.put("precio_contado",itemProductoEntrega.getProducto().getPrecioContado());
            values.put("imagen",itemProductoEntrega.getProducto().getImagen());
            values.put("comision",itemProductoEntrega.getProducto().getComision());

            Cursor cursor = super.getWritableDatabase().rawQuery("SELECT * FROM productos WHERE usuario = ? AND _id = ?", new String[]{ username,itemProductoEntrega.getProductoId().toString() });

            if(cursor.getCount() > 0 ){
                values.put("cantidad", getFieldI(cursor,"cantidad") + itemProductoEntrega.getCantidad());
                super.updateData(values);
            }else {
                values.put("cantidad",itemProductoEntrega.getCantidad());
                super.saveData(values);
            }

        }
    }

    @Override
    public void getProductos(String query) {
        Cursor cursor = super.getReadableDatabase().rawQuery("SELECT * FROM productos WHERE nombre = ? AND usuario = ?", new String[]{ query , username });
        ArrayList<ProductoP> productos = new ArrayList<>();
        if(cursor != null) cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            ProductoP  producto = new ProductoP(getFieldI(cursor,"_id"),
                    getField(cursor,"nombre"),
                    getField(cursor,"descripcion"),
                    getFieldI(cursor,"cantidad"),
                    getField(cursor,"precio_contado"),
                    getField(cursor,"precio_credito"),
                    getField(cursor,"imagen"));

            productos.add(producto);
            cursor.moveToNext();
        }

        productosPresenter.showProductos(productos);
    }

    @Override
    public void getProducto(int id) {
        Cursor cursor = super.getReadableDatabase().rawQuery("SELECT * FROM productos WHERE _id = ? AND usuario = ?", new String[]{ String.valueOf(id), username });

        if(cursor != null) cursor.moveToFirst();

        ProductoP  producto = new ProductoP(getFieldI(cursor,"_id"),
                getField(cursor,"nombre"),
                getField(cursor,"descripcion"),
                getFieldI(cursor,"cantidad"),
                getField(cursor,"precio_contado"),
                getField(cursor,"precio_credito"),
                getField(cursor,"imagen"));
        productosPresenter.showProducto(producto);
    }

    public static class ProductosEntry extends TablaBase implements BaseColumns {
        public static final String TABLA = "productos";

        public static final String COLUMNA_DESCRIPCION = "descripcion varchar(150) null";
        public static final String COLUMNA_PRECIO_COSTO = "precio_credito varchar(150) not null";
        public static final String COLUMNA_PRECIO_CONTADO = "precio_contado varchar(150) not null";
        public static final String COLUMNA_IMAGEN = "imagen varchar(150) null";
        public static final String COLUMNA_COMISION = "comision varchar(50) null";
        public static final String COLUMNA_CANTIDAD = "cantidad int(10) not null";

        public static final String[] COLUMNAS = new String[]{ COLUMNA_USUARIO_ID,COLUMNA_NOMBRE,COLUMNA_DESCRIPCION,COLUMNA_PRECIO_COSTO,COLUMNA_PRECIO_CONTADO,COLUMNA_IMAGEN,COLUMNA_COMISION,COLUMNA_CANTIDAD };

    }
}
