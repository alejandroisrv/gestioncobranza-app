package com.gestioncobranza.mainactivity.Productos.View;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gestioncobranza.mainactivity.Productos.Model.Entrega;
import com.gestioncobranza.mainactivity.Productos.Model.ProductoP;
import com.gestioncobranza.mainactivity.Productos.Presenter.ProductosPresenter;
import com.gestioncobranza.mainactivity.Productos.Producto;
import com.gestioncobranza.mainactivity.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductoFragment extends Fragment implements Producto.view{


    private Producto.presenter productoPresenter;

    public ProductoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        productoPresenter = new ProductosPresenter(this);
        getDatosApi();
        return inflater.inflate(R.layout.fragment_producto, container, false);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        menu.clear();
        getActivity().getMenuInflater().inflate(R.menu.productos_menun,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void getDatos() {
        productoPresenter.getDatos();
    }

    @Override
    public void getDatosApi() {
        productoPresenter.getDatosApi(() -> getDatos());
    }

    @Override
    public void showProductos(ArrayList<ProductoP> productos) {

    }

    @Override
    public void showProducto(ProductoP producto) {

    }

    @Override
    public void showEntregas(ArrayList<Entrega> entregas) {

    }

    @Override
    public void showEntrega(Entrega entrega) {

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
