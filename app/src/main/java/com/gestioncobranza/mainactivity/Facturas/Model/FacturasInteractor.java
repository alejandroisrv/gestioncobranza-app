package com.gestioncobranza.mainactivity.Facturas.Model;

import com.gestioncobranza.mainactivity.DB.FacturaDB;
import com.gestioncobranza.mainactivity.Facturas.Factura;
import com.gestioncobranza.mainactivity.Facturas.Model.Repository.AbonosFacturasRepository;
import com.gestioncobranza.mainactivity.Facturas.Model.Repository.ProductoFacturasRepository;
import com.gestioncobranza.mainactivity.Facturas.Model.Repository.FacturasRepository;
import com.gestioncobranza.mainactivity.MainInterface;

import java.util.ArrayList;

public class FacturasInteractor implements Factura.interactor {


    private final Factura.repository facturasRepository;
    private final Factura.abonosRepositor abonosRepository;
    private final Factura.productosFacturasRepository facturasProductosRepository;


    public FacturasInteractor(Factura.presenter facturasPresenter) {
        this.facturasRepository = new FacturasRepository(facturasPresenter);
        this.abonosRepository = new AbonosFacturasRepository(facturasPresenter);
        this.facturasProductosRepository = new ProductoFacturasRepository(facturasPresenter);
    }

    @Override
    public void getDatosApi(MainInterface.onResult onResult) {
        facturasRepository.getDatosApi(onResult);
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
    public void syncData() {

    }


    @Override
    public void saveFacturas(ArrayList<FacturaDB.Factura> facturas) {

    }
}
