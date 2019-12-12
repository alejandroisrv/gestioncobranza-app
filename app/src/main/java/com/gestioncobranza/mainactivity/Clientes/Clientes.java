package com.gestioncobranza.mainactivity.Clientes;

import com.gestioncobranza.mainactivity.Clientes.Model.Cliente;
import com.gestioncobranza.mainactivity.MainInterface;
import com.gestioncobranza.mainactivity.Rutas.Model.Ruta;

import java.util.ArrayList;


public interface Clientes {

    interface view extends MainInterface.view {
        void getClientesByRutas(int id,String query);
        void addCliente(Cliente cliente);
        void showClientes(ArrayList<Ruta> rutas);
    }

    interface presenter extends MainInterface.presenter {
        void addCliente(Cliente cliente);
        void showClientes(ArrayList<Ruta> rutas);
        void getClientesByRutas(int id,String query);

    }

    interface interactor extends MainInterface.interactor {
        void addCliente(Cliente cliente);
        void getClientesByRutas(int id,String query);
    }

    interface repository extends MainInterface.repository {
        void addCliente(Cliente cliente);
        void getClientesByRutas(int id,String query);
    }
}
