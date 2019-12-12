package com.gestioncobranza.mainactivity.Productos.Presenter;

import android.content.Context;

import com.gestioncobranza.mainactivity.MainInterface;
import com.gestioncobranza.mainactivity.Productos.Model.Entrega;
import com.gestioncobranza.mainactivity.Productos.Model.ProductoP;
import com.gestioncobranza.mainactivity.Productos.Model.ProductosInteractor;
import com.gestioncobranza.mainactivity.Productos.Producto;

import java.util.ArrayList;

public class ProductosPresenter implements Producto.presenter {
    private final Producto.interactor productosInteractor;
    private Producto.view view;

    public ProductosPresenter(Producto.view view) {
        this.view = view;
        this.productosInteractor = new ProductosInteractor(this);
    }

    @Override
    public Context getView() {
        return view.getContext();
    }

    @Override
    public void getDatos() {
        productosInteractor.getDatos();
    }

    @Override
    public void getDatos(String query) {
        productosInteractor.getDatos(query);
    }

    @Override
    public void getItem(int id) {
        productosInteractor.getItem(id);
    }

    @Override
    public void getDatosApi(MainInterface.onResult onResult) {
        productosInteractor.getDatosApi(onResult);
    }

    @Override
    public void syncData() {

    }

    @Override
    public void showLoading(String text) {
        view.showLoading(text);
    }

    @Override
    public void showAlert(String titulo, String text) {
        view.showAlert(titulo,text);
    }

    @Override
    public void stopLoading() {
        view.stopLoading();
    }

    @Override
    public void stopLoading(String text) {
        view.stopLoading(text);
    }

    @Override
    public void showProductos(ArrayList<ProductoP> productos) {
        view.showProductos(productos);
    }

    @Override
    public void showProducto(ProductoP producto) {
        view.showProducto(producto);
    }

    @Override
    public void showEntregas(ArrayList<Entrega> entregas) {
        view.showEntregas(entregas);
    }

    @Override
    public void showEntrega(Entrega entrega) {
        view.showEntrega(entrega);
    }
}
