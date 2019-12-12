package com.gestioncobranza.mainactivity.Facturas.Model.Repository;

import android.content.ContentValues;
import android.content.Context;
import android.provider.BaseColumns;

import com.gestioncobranza.mainactivity.DB.DbManager;
import com.gestioncobranza.mainactivity.DB.FacturaDB;
import com.gestioncobranza.mainactivity.DB.TablaBase;
import com.gestioncobranza.mainactivity.Facturas.Factura;

import java.util.ArrayList;

public class AbonosFacturasRepository extends DbManager implements Factura.abonosRepositor{

    private static final String[] COLUMNAS = AbonosEntry.COLUMNAS;
    private static final String TABLA = AbonosEntry.TABLE;

    public AbonosFacturasRepository(Factura.presenter facturasPresenter) {
        super(facturasPresenter.getView(), TABLA, COLUMNAS);
    }

    @Override
        public void saveAbonos(ArrayList<FacturaDB.Abono> abonos) {
            for (int i = 0; i < abonos.size(); i++) {
                ContentValues values = new ContentValues();
                FacturaDB.Abono abono = abonos.get(i);
                values.put("venta_id", abono.getVentaId());
                values.put("cliente_id", abono.getClienteId());
                values.put("monto", abono.getMonto());
                values.put("saldo", abono.getSaldo());
                values.put("fecha", abono.getFecha());
                super.insert(values);
            }
        }

        public static class AbonosEntry extends TablaBase implements BaseColumns {
            public static final String TABLE = "pagos_clientes";
            public static final String COLUMNA_VENTA_ID = "venta_id int not null";
            public static final String COLUMNA_CLIENTE_ID = "cliente_id int not null";
            public static final String COLUMNA_MONTO = "monto varchar(50) not null";
            public static final String COLUMNA_SALDO = "saldo varchar(50) not null";
            public static final String COLUMNA_FECHA = "fecha text not null";

            public static final String[] COLUMNAS = new String[]{COLUMNA_VENTA_ID,COLUMNA_CLIENTE_ID,COLUMNA_MONTO,COLUMNA_SALDO,COLUMNA_FECHA};
        }

    }


