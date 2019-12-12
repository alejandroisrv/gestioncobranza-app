package com.gestioncobranza.mainactivity.Facturas.View;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gestioncobranza.mainactivity.Facturas.Factura;
import com.gestioncobranza.mainactivity.Facturas.Model.Venta;
import com.gestioncobranza.mainactivity.Facturas.Presenter.FacturasPresenter;
import com.gestioncobranza.mainactivity.MainInterface;
import com.gestioncobranza.mainactivity.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FacturasFragment extends Fragment implements Factura.view {

    Factura.presenter facturaPresenter;

    public FacturasFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        facturaPresenter = new FacturasPresenter(this);
        getDatosApi();
        return inflater.inflate(R.layout.fragment_facturas, container, false);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.facturas_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void getDatos() {
        facturaPresenter.getDatos();
    }

    @Override
    public void getDatosApi() {
        facturaPresenter.getDatosApi(() -> getDatos());
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

    @Override
    public void showVentas(ArrayList<Venta> ventas) {

    }

    @Override
    public void showVenta(Venta venta) {

    }
}
