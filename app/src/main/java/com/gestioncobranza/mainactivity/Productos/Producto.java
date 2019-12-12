package com.gestioncobranza.mainactivity.Productos;

import com.gestioncobranza.mainactivity.DB.ProductoDB;
import com.gestioncobranza.mainactivity.MainInterface;
import com.gestioncobranza.mainactivity.Productos.Model.Entrega;
import com.gestioncobranza.mainactivity.Productos.Model.ProductoP;

import java.util.ArrayList;

public interface Producto {

    interface view extends MainInterface.view {
        void showProductos(ArrayList<ProductoP> productos);
        void showProducto(ProductoP producto);
        void showEntregas(ArrayList<Entrega> entregas);
        void showEntrega(Entrega entrega);
    }

    interface presenter extends MainInterface.presenter {
        void showProductos(ArrayList<ProductoP> productos);
        void showProducto(ProductoP producto);
        void showEntregas(ArrayList<Entrega> entregas);
        void showEntrega(Entrega entrega);
    }

    interface interactor extends MainInterface.interactor {
        void getEntregas();
        void getProductos(String query);
        void getEntrega(int id);
        void getProducto(int id);
    }

    interface productosRepository {
        void saveProductos(ArrayList<ProductoDB.ItemProductoEntrega> productos);
        void getProductos(String query);
        void getProducto(int id);
    }

    interface entradasRepository extends MainInterface.repository {
        void saveEntregas(ArrayList<ProductoDB.Entrega> entregas);
        void getEntregas();
        void getEntrega(int id);
    }
}
