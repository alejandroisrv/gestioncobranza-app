package com.gestioncobranza.mainactivity.Productos.Model;

import android.provider.BaseColumns;
import android.widget.TableLayout;

import com.gestioncobranza.mainactivity.DB.TablaBase;

public class ProductosReposityr {


    public static class ProductosEntry extends TablaBase implements BaseColumns{
        public static final String COLUMNA_DESCRIPCION = "descripcion varchar(150) null";
        public static final String COLUMNA_PRECIO_COSTO = "precio_costo varchar(150) not null";
        public static final String COLUMNA_PRECIO_CONTADO = "precio_contado varchar(150) not null";
        public static final String COLUMNA_IMAGEN = "imagen varchar(150) null";
        public static final String COLUMNA_COMISION = "comision varchar(50) null";
        public static final String COLUMNA_CANTIDAD = "cantidad int(10) not null";
        public static final String[] COLUMNAS = new String[]{ COLUMNA_USUARIO_ID,COLUMNA_NOMBRE,COLUMNA_DESCRIPCION,COLUMNA_PRECIO_COSTO,COLUMNA_PRECIO_CONTADO,COLUMNA_IMAGEN,COLUMNA_COMISION,COLUMNA_CANTIDAD };

    }
}
