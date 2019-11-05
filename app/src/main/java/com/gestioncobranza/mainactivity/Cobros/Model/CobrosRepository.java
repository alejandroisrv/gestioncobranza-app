package com.gestioncobranza.mainactivity.Cobros.Model;

import android.content.Context;
import android.provider.BaseColumns;

import com.gestioncobranza.mainactivity.DB.DbManager;
import com.gestioncobranza.mainactivity.DB.TablaBase;
import com.google.android.material.tabs.TabLayout;

public class CobrosRepository extends DbManager {


    public class CobrosItemR extends DbManager{

        private static final String TABLA = CobrosItemEntry.TABLE ;
        private static final String[] COLUMNAS = CobrosItemEntry.COLUMNAS ;

        public CobrosItemR() {
            super(context, TABLA,COLUMNAS);
        }
    }

    public static class CobrosEntry extends TablaBase implements BaseColumns{
        public static final String TABLE ="cobros";
        public static final String COLUMNA_RUTA_ID ="ruta_id int(10) not null";
        public static final String COLUMNA_COMISION ="comision varchar(50) null";

        public static final String[] COLUMNAS = new String[]{COLUMNA_USUARIO_ID,COLUMNA_RUTA_ID,COLUMNA_COMISION};
    }

    public static class CobrosItemEntry {
        public static final String TABLE ="cobros_item";
        public static final String COLUMNA_COBRO_ID ="cobro_id int(10) not null";
        public static final String COLUMNA_RUTA_ITEM_ID ="ruta_item_id int(10) not null";
        public static final String COLUMNA_VENTA_ID ="venta_id int(10) not null";
        public static final String COLUMNA_MONTO ="monto varchar(50) not null";
        public static final String COLUMNA_COMISION ="comision varchar(50) not null";
        public static final String COLUMNA_ESTADO ="comision varchar(50) not null";
        public static final String COLUMNA_OBSERVACION ="observacion varchar(50) null";
        public static final String COLUMNA_FECHA_CULMINACION ="fecha_culminacion varchar(50) not null";
        public static final String[] COLUMNAS = new String[]{COLUMNA_COBRO_ID,COLUMNA_RUTA_ITEM_ID,COLUMNA_VENTA_ID,COLUMNA_MONTO,COLUMNA_ESTADO,COLUMNA_OBSERVACION,COLUMNA_FECHA_CULMINACION,COLUMNA_COMISION};

    }
}
