package com.gestioncobranza.mainactivity.Clientes.Presenter;

import android.content.Context;

import com.gestioncobranza.mainactivity.Clientes.Clientes;
import com.gestioncobranza.mainactivity.Clientes.Model.Cliente;
import com.gestioncobranza.mainactivity.Clientes.Model.ClientesInteractor;
import com.gestioncobranza.mainactivity.MainInterface;
import com.gestioncobranza.mainactivity.Rutas.Model.Ruta;

import java.util.ArrayList;

public class ClientesPresenter implements Clientes.presenter {
    private final Clientes.view clientesView;
    private final Clientes.interactor clientesInteractor;

    public ClientesPresenter(Clientes.view clientesView) {
        this.clientesView = clientesView;
        this.clientesInteractor = new ClientesInteractor(this);
    }

    @Override
    public void addCliente(Cliente cliente) {

    }

    @Override
    public void showClientes(ArrayList<Ruta> rutas) {
        clientesView.showClientes(rutas);
    }

    @Override
    public void getClientesByRutas(int id, String query) {
        clientesInteractor.getClientesByRutas(id,query);

    }

    @Override
    public Context getView() {
        return clientesView.getContext();
    }

    @Override
    public void getDatos() {
        clientesInteractor.getDatos();
    }

    @Override
    public void getDatos(String query) { clientesInteractor.getDatos(query);}

    @Override
    public void getItem(int id) {

    }

    @Override
    public void getDatosApi(MainInterface.onResult onResult) {
        clientesInteractor.getDatosApi(onResult);
    }

    @Override
    public void syncData() {

    }

    @Override
    public void showLoading(String text) {

    }

    @Override
    public void showAlert(String titulo, String text) {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void stopLoading(String text) {

    }
}
