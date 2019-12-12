package com.gestioncobranza.mainactivity.Cobros.Presenter;

import android.content.Context;

import com.gestioncobranza.mainactivity.Cobros.Cobros;
import com.gestioncobranza.mainactivity.Cobros.Model.Cobro;
import com.gestioncobranza.mainactivity.Cobros.Model.CobroResultado;
import com.gestioncobranza.mainactivity.Cobros.Model.CobrosInteractor;
import com.gestioncobranza.mainactivity.MainInterface;

import java.util.ArrayList;

public class CobrosPresenter implements Cobros.presenter {
    private final Cobros.view cobrosView;
    private final Cobros.interactor cobrosInteractor;

    public CobrosPresenter(Cobros.view view) {
        this.cobrosView = view;
        this.cobrosInteractor = new CobrosInteractor(this);
    }

    @Override
    public void showData(ArrayList<Cobro> cobros) {
        cobrosView.showData(cobros);
    }

    @Override
    public void showItem(Cobro cobro) {
        cobrosView.showItem(cobro);
    }

    @Override
    public void sendResult(CobroResultado cobroResultado) {
        cobrosInteractor.sendResult(cobroResultado);
    }

    @Override
    public void getDatos() {
        cobrosInteractor.getDatos();
    }

    @Override
    public void getDatos(String query) {
        cobrosInteractor.getDatos(query);
    }

    @Override
    public void getItem(int id) {
        cobrosInteractor.getItem(id);
    }

    @Override
    public void getDatosApi(MainInterface.onResult onResult) {
        cobrosInteractor.getDatosApi(onResult);
    }

    @Override
    public void syncData() {

    }

    @Override
    public void showLoading(String text) {
        cobrosView.showLoading(text);
    }

    @Override
    public void showAlert(String titulo, String text) {
        cobrosView.showAlert(titulo,text);
    }

    @Override
    public void stopLoading() {
        cobrosView.stopLoading();
    }

    @Override
    public void stopLoading(String text) {
        cobrosView.stopLoading(text);
    }

    @Override
    public Context getView() {
        return cobrosView.getContext();
    }
}
