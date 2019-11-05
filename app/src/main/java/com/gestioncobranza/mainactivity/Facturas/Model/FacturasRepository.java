package com.gestioncobranza.mainactivity.Facturas.Model;

import android.provider.BaseColumns;

import com.gestioncobranza.mainactivity.DB.TablaBase;

public class FacturasRepository {


    public static class FacturasEntry extends TablaBase implements BaseColumns{
        public static String COLUMNA_COD = "cod int not null";
        public static String COLUMNA_USER_ID = "user_id int not null";
        public static String COLUMNA_CLIENTE_ID = "cliente_id int not null";
        public static String COLUMNA_TIPO_VENTA = "tipo_venta varchar(250) not null";
        public static String COLUMNA_ABONO = "abono varchar(50) null default '0.0' ";
        public static String COLUMNA_DESCUENTO = "descuento varchar(50) null default '0.0' ";
        public static String COLUMNA_PERIODO_PAGO = "periodo_pago varchar(50) not null";
        public static String COLUMNA_CUOTAS = "cuotas int not null";
        public static String COLUMNA_ESTADO = "estado int not null";
        public static String COLUMNA_MONTO = "monto varchar(50) not null";
        public static String COLUMNA_FECHA_ACTUALIZACION = "fecha_actualizacion varchar(50) not null";
        public static String COLUMNA_FECHA_CREACION = "fecha_creacion varchar(50) not null";

        public static final String[] COLUMNAS = new String[]{ COLUMNA_USUARIO_ID,
                COLUMNA_COD,COLUMNA_USER_ID,COLUMNA_CLIENTE_ID,COLUMNA_TIPO_VENTA,COLUMNA_ABONO,
                COLUMNA_DESCUENTO,
                COLUMNA_PERIODO_PAGO,
                COLUMNA_CUOTAS,
                COLUMNA_ESTADO,
                COLUMNA_MONTO,
                COLUMNA_FECHA_ACTUALIZACION,
                COLUMNA_FECHA_CREACION};

        public static class ProductosVentasEntry extends TablaBase implements BaseColumns {
            public static String TABLE = "productos_ventas";
            public static String COLUMNA_USER_ID = "venta_id int not null";
            public static String COLUMNA_PRODUCTO_NOMBRE = "producto_nombre varchar(250) not null";
            public static String COLUMNA_MONTO = "producto_precio varchar(50) not null";
            public static String COLUMNA_CANTIDAD = "cantidad int not null";
            public static String[] COLUMNAS = new String[]{COLUMNA_USER_ID,COLUMNA_PRODUCTO_NOMBRE,COLUMNA_MONTO,COLUMNA_CANTIDAD,};
        }





    }
}
