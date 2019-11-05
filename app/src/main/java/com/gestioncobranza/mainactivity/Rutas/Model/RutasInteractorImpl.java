package com.gestioncobranza.mainactivity.Rutas.Model;

import com.gestioncobranza.mainactivity.Rutas.Rutas;

public class RutasInteractorImpl implements Rutas.interactor{

    private final Rutas.presenter rutasPresenter;
    private final Rutas.repository rutasRepository;

    public RutasInteractorImpl(Rutas.presenter rutasPresenter) {
        this.rutasPresenter = rutasPresenter;
        this.rutasRepository = new RutasRepositoryImpl(rutasPresenter);
    }

    @Override
    public void getDatos() {
        rutasRepository.getDatos();
    }

    @Override
    public void getDatos(String query) {
        rutasRepository.getDatos(query);
    }

    @Override
    public void getItem(int id) {
        rutasRepository.getItem(id);
    }

    @Override
    public void getDatosApi() {
        rutasRepository.getDatosApi();
    }

    @Override
    public void syncData() {
        rutasRepository.syncData();
    }
}
