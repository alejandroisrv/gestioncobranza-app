package com.gestioncobranza.mainactivity.Cobros.Model;

import com.gestioncobranza.mainactivity.Cobros.Cobros;
import com.gestioncobranza.mainactivity.Cobros.Model.Repository.CobrosRepository;
import com.gestioncobranza.mainactivity.MainInterface;

public class CobrosInteractor implements Cobros.interactor {
    private final Cobros.repository cobrosRepository;

    public CobrosInteractor(Cobros.presenter cobrosPresenter) {
        this.cobrosRepository = new CobrosRepository(cobrosPresenter);
    }

    @Override
    public void sendResult(CobroResultado cobroResultado) {
        cobrosRepository.sendResult(cobroResultado);
    }

    @Override
    public void getDatos() {
        cobrosRepository.getDatos();
    }

    @Override
    public void getDatos(String query) {
    cobrosRepository.getDatos(query);
    }

    @Override
    public void getItem(int id) {
        cobrosRepository.getItem(id);
    }

    @Override
    public void getDatosApi(MainInterface.onResult onResult) {
        cobrosRepository.getDatosApi(onResult);
    }

    @Override
    public void syncData() {
        cobrosRepository.syncData();
    }
}
