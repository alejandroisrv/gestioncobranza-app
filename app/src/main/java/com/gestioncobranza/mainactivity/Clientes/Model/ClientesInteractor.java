package com.gestioncobranza.mainactivity.Clientes.Model;

import com.gestioncobranza.mainactivity.Clientes.Clientes;
import com.gestioncobranza.mainactivity.Clientes.Presenter.ClientesPresenter;
import com.gestioncobranza.mainactivity.MainInterface;

public class ClientesInteractor implements Clientes.interactor {


    private final Clientes.repository clientesRepository;

    public ClientesInteractor(ClientesPresenter clientesPresenter) {
        this.clientesRepository = new ClientesRepository(clientesPresenter);
    }

    @Override
    public void addCliente(Cliente cliente) {

    }

    @Override
    public void getClientesByRutas(int id, String query) {
        clientesRepository.getClientesByRutas(id, query);
    }

    @Override
    public void getDatos() {
        clientesRepository.getDatos();
    }

    @Override
    public void getDatos(String query   ) {
        clientesRepository.getDatos(query);
    }

    @Override
    public void getItem(int id) {
        clientesRepository.getItem(id);
    }

    @Override
    public void getDatosApi(MainInterface.onResult onResult) {
        clientesRepository.getDatosApi(onResult);
    }

    @Override
    public void syncData() {

    }
}
