
package com.gestioncobranza.mainactivity.Clientes.View;


import android.annotation.SuppressLint;
import android.app.MediaRouteButton;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gestioncobranza.mainactivity.Clientes.Clientes;
import com.gestioncobranza.mainactivity.Clientes.Model.Cliente;
import com.gestioncobranza.mainactivity.Clientes.Presenter.ClientesPresenter;
import com.gestioncobranza.mainactivity.MainInterface;
import com.gestioncobranza.mainactivity.R;
import com.gestioncobranza.mainactivity.Rutas.Model.Ruta;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ClientesFragment extends Fragment implements Clientes.view {


    private Clientes.presenter clientesPresenter;
    private RecyclerView rv;
    private SwipeRefreshLayout swipeRefreshLayout;
    private TextView textVacio;
    private LinearLayout main;

    public ClientesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_clientes, container, false);
        clientesPresenter = new ClientesPresenter(this);
        rv = view.findViewById(R.id.rv_clientes);
        swipeRefreshLayout = view.findViewById(R.id.refresh);
        textVacio = view.findViewById(R.id.msj_vacio);
        main = view.findViewById(R.id.ll_fragment);
        getDatosApi();
        setHasOptionsMenu(true);
        swipeRefreshLayout.setOnRefreshListener(() -> {
            getDatosApi();
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.clientes_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public void getClientesByRutas(int id, String query) {

    }

    @Override
    public void addCliente(Cliente cliente) {

    }

    public void showClientes(ArrayList<Ruta> rutas) {



        rv.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        rv.setAdapter(new SectionsClientesAdaptador(rutas,R.layout.cardview_list_clientes,getActivity(),clientesPresenter));
        rv.setHasFixedSize(true);
        rv.setNestedScrollingEnabled(false);

        if(swipeRefreshLayout.isRefreshing())
            swipeRefreshLayout.setRefreshing(false);

        showEmptyList(rutas.size() == 0);
    }

    public void showEmptyList(Boolean invisible){
        rv.setVisibility(invisible ? View.INVISIBLE : View.VISIBLE);
        textVacio.setVisibility(invisible ? View.VISIBLE : View.INVISIBLE);
        main.setGravity(invisible ? Gravity.CENTER  : Gravity.NO_GRAVITY);
    }

    @Override
    public void getDatos() {
        clientesPresenter.getDatos();
    }

    @Override
    public void getDatosApi() {
        clientesPresenter.getDatosApi(() -> getDatos());
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
