package com.gestioncobranza.mainactivity.Rutas.Presenter;

import android.content.Context;

import com.gestioncobranza.mainactivity.Rutas.Model.Ruta;
import com.gestioncobranza.mainactivity.Rutas.Model.RutasInteractorImpl;
import com.gestioncobranza.mainactivity.Rutas.Rutas;

import java.util.ArrayList;

public class RutasPresenterImpl implements Rutas.presenter {

    private final Rutas.view rutasView;
    private final Rutas.interactor rutasInteractor;

    public RutasPresenterImpl(Rutas.view rutasView) {
        this.rutasView = rutasView;
        this.rutasInteractor = new RutasInteractorImpl(this);
    }

    @Override
    public void getDatos() {
        rutasInteractor.getDatos();
    }

    @Override
    public void getDatos(String query) {
        rutasInteractor.getDatos(query);
    }

    @Override
    public void showData(ArrayList<Ruta> rutas) {
        rutasView.showData(rutas);
    }

    @Override
    public void showItem(Ruta ruta) {
        rutasView.showItem(ruta);
    }

    @Override
    public void getItem(int id) {
        rutasInteractor.getItem(id);
    }

    @Override
    public void getDatosApi() {
        rutasInteractor.getDatosApi();
    }

    @Override
    public void syncData() {
        rutasInteractor.syncData();
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

    @Override
    public Context getView() {
        return rutasView.getContext();
    }
}
