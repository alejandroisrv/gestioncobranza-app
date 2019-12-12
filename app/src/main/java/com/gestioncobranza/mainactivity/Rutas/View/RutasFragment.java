package com.gestioncobranza.mainactivity.Rutas.View;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gestioncobranza.mainactivity.MainInterface;
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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rutasPresenter = new RutasPresenterImpl(this);
        getDatosApi();
        return inflater.inflate(R.layout.fragment_rutas, container, false);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        menu.clear();
        getActivity().getMenuInflater().inflate(R.menu.rutas_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
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
        rutasPresenter.getDatosApi(new MainInterface.onResult() {
            @Override
            public void doAction() {
                getDatos();
            }
        });
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
