package com.gestioncobranza.mainactivity.Rutas.View;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gestioncobranza.mainactivity.R;
import com.gestioncobranza.mainactivity.Rutas.Model.Ruta;
import com.gestioncobranza.mainactivity.Rutas.Presenter.RutasPresenterImpl;
import com.gestioncobranza.mainactivity.Rutas.Rutas;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RutasFragment extends Fragment implements Rutas.view {


    private Rutas.presenter rutasPresenter;

    public RutasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rutasPresenter = new RutasPresenterImpl(this);
        getDatos();
        return inflater.inflate(R.layout.fragment_rutas, container, false);
    }

    @Override
    public void showData(ArrayList<Ruta> rutas) {

    }

    @Override
    public void showItem(Ruta ruta) {

    }

    @Override
    public void getDatos() {
        rutasPresenter.getDatos();
    }

    @Override
    public void getDatosApi() {
        rutasPresenter.getDatosApi();
    }

    @Override
    public void syncData() {
        rutasPresenter.syncData();
    }

    @Override
    public void getItem(int id) {
        rutasPresenter.getItem(id);
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
