package com.gestioncobranza.mainactivity.Clientes;

import com.gestioncobranza.mainactivity.Clientes.Model.Cliente;
import com.gestioncobranza.mainactivity.MainInterface;


public interface Clientes {

    interface view extends MainInterface.view {
        void addCliente(Cliente cliente);
    }

    interface presenter extends MainInterface.presenter {
        void addCliente(Cliente cliente);
    }

    interface interactor extends MainInterface.interactor {
        void addCliente(Cliente cliente);
    }

    interface repository extends MainInterface.repository {
        void addCliente(Cliente cliente);
    }
}
