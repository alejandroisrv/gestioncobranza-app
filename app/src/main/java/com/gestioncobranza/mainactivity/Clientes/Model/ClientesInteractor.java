package com.gestioncobranza.mainactivity.Clientes.Model;

import com.gestioncobranza.mainactivity.Clientes.Clientes;
import com.gestioncobranza.mainactivity.Clientes.Presenter.ClientesPresenter;

public class ClientesInteractor implements Clientes.interactor {


    private final Clientes.repository clientesRepository;

    public ClientesInteractor(ClientesPresenter clientesPresenter) {
        this.clientesRepository = new ClientesRepository(clientesPresenter);
    }

    @Override
    public void addCliente(Cliente cliente) {

    }

    @Override
    public void getDatos() {

    }

    @Override
    public void getDatos(String query) {

    }

    @Override
    public void getItem(int id) {

    }

    @Override
    public void getDatosApi() {

    }

    @Override
    public void syncData() {

    }
}
