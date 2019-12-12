package com.gestioncobranza.mainactivity.Facturas.Presenter;

import android.content.Context;

import com.gestioncobranza.mainactivity.Facturas.Factura;
import com.gestioncobranza.mainactivity.Facturas.Model.FacturasInteractor;
import com.gestioncobranza.mainactivity.Facturas.Model.Venta;
import com.gestioncobranza.mainactivity.MainInterface.onResult;

import java.util.ArrayList;

public class FacturasPresenter implements Factura.presenter {
    private final Factura.view facturasView;
    private final Factura.interactor facturasInteractor;

    public FacturasPresenter(Factura.view facturasFragment) {
        this.facturasView = facturasFragment;
        this.facturasInteractor = new FacturasInteractor(this);
    }

    @Override
    public void downloadData() {

    }

    @Override
    public void showVentas(ArrayList<Venta> ventas) {
        facturasView.showVentas(ventas);
    }

    @Override
    public void showVenta(Venta venta) {
        facturasView.showVenta(venta);
    }

    @Override
    public Context getView() {
        return facturasView.getContext();
    }

    @Override
    public void getDatos() {

    }

    @Override
    public void getDatos(String query) {

    }

    @Override
    public void getItem(int id) {

    }

    @Override
    public void getDatosApi(onResult onResult) {
        facturasInteractor.getDatosApi(onResult);
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
