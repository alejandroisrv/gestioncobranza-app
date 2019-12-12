package com.gestioncobranza.mainactivity.Facturas;

import com.gestioncobranza.mainactivity.DB.FacturaDB;
import com.gestioncobranza.mainactivity.Facturas.Model.ProductoFactura;
import com.gestioncobranza.mainactivity.Facturas.Model.Venta;
import com.gestioncobranza.mainactivity.MainInterface;
import com.gestioncobranza.mainactivity.Productos.Producto;

import java.util.ArrayList;

public interface Factura {

    interface view extends MainInterface.view {
        void showVentas(ArrayList<Venta> ventas);
        void showVenta(Venta venta);
    }

    interface presenter extends MainInterface.presenter {
        void downloadData();
        void showVentas(ArrayList<Venta> ventas);
        void showVenta(Venta venta);
    }

    interface interactor extends MainInterface.interactor {
        void saveFacturas(ArrayList<FacturaDB.Factura> facturas);
    }

    interface repository extends MainInterface.repository {
        void saveFacturas(ArrayList<FacturaDB.Factura> facturas);
    }

    interface abonosRepositor {
        void saveAbonos(ArrayList<FacturaDB.Abono> abonos);
    }

    interface productosFacturasRepository {
        void saveProductosFactura(ArrayList<ProductoFactura> productoFacturas);
    }
}
