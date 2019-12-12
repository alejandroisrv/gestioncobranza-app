package com.gestioncobranza.mainactivity.Clientes.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.gestioncobranza.mainactivity.Clientes.Clientes;
import com.gestioncobranza.mainactivity.Clientes.Model.Cliente;
import com.gestioncobranza.mainactivity.Clientes.Presenter.ClientesPresenter;
import com.gestioncobranza.mainactivity.R;
import com.gestioncobranza.mainactivity.Rutas.Model.Ruta;

import java.util.ArrayList;

public class ClientesRutasActivity extends AppCompatActivity implements Clientes.view {

    private Toolbar toolbar;
    private RecyclerView rv;
    private Clientes.presenter clientesPresenter;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_rutas);
        clientesPresenter = new ClientesPresenter(this);
        Intent intent = getIntent();
        rv = findViewById(R.id.rv_clientesrutas_detail);
        id = intent.getIntExtra("id",0);
        configureToolbar(intent.getStringExtra("nombre"));
        getClientesByRutas(id,"");
    }

    private void configureToolbar(String title) {
        toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void showClientes(ArrayList<Ruta> rutas) {
        rv.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        rv.setAdapter(new ClientesAdaptadorRV(getContext(),R.layout.cardview_clientes,rutas.get(0).getClientes(),clientesPresenter));
        rv.setHasFixedSize(true);
        rv.setNestedScrollingEnabled(false);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void getClientesByRutas(int id, String query) {
        clientesPresenter.getClientesByRutas(id, query);
    }

    @Override
    public void addCliente(Cliente cliente) {

    }



    @Override
    public void getDatos() {

    }

    @Override
    public void getDatosApi() {


    }

    @Override
    public void syncData() {

    }

    @Override
    public void getItem(int id) {

    }

    @Override
    public Context getContext() {
        return getApplicationContext();
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
