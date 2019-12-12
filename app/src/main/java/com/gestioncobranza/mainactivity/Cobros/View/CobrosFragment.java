package com.gestioncobranza.mainactivity.Cobros.View;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gestioncobranza.mainactivity.Cobros.Cobros;
import com.gestioncobranza.mainactivity.Cobros.Model.Cobro;
import com.gestioncobranza.mainactivity.Cobros.Model.CobroResultado;
import com.gestioncobranza.mainactivity.Cobros.Presenter.CobrosPresenter;
import com.gestioncobranza.mainactivity.MainInterface;
import com.gestioncobranza.mainactivity.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CobrosFragment extends Fragment implements Cobros.view {


    private Cobros.presenter cobrosPresenter;

    public CobrosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        cobrosPresenter = new CobrosPresenter(this);
        getDatosApi();
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_cobros, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        menu.clear();
        getActivity().getMenuInflater().inflate(R.menu.cobros_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void showDetail() {

    }

    @Override
    public void showData(ArrayList<Cobro> cobros) {

    }

    @Override
    public void showItem(Cobro cobro) {

    }

    @Override
    public void sendResult(CobroResultado cobroResultado) {

    }

    @Override
    public void getDatos() {
        cobrosPresenter.getDatos();
    }

    @Override
    public void getDatosApi() {
        cobrosPresenter.getDatosApi(() -> getDatos());
    }

    @Override
    public void syncData() {

    }

    @Override
    public void getItem(int id) {

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
