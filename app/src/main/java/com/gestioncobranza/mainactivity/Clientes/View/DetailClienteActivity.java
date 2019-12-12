package com.gestioncobranza.mainactivity.Clientes.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.gestioncobranza.mainactivity.Clientes.Clientes;
import com.gestioncobranza.mainactivity.Clientes.Model.Cliente;
import com.gestioncobranza.mainactivity.R;
import com.gestioncobranza.mainactivity.Rutas.Model.Ruta;

import java.util.ArrayList;

public class DetailClienteActivity extends AppCompatActivity implements Clientes.view {

    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cliente);
        Intent intent = getIntent();
        id = intent.getIntExtra("id",0);
        initView();
        getItem(id);
    }

    private void initView() {

    }

    @Override
    public void getClientesByRutas(int id, String query) {

    }

    @Override
    public void addCliente(Cliente cliente) {

    }

    @Override
    public void showClientes(ArrayList<Ruta> rutas) {

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
        return null;
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
