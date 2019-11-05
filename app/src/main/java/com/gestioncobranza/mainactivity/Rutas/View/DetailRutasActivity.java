package com.gestioncobranza.mainactivity.Rutas.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.gestioncobranza.mainactivity.R;
import com.gestioncobranza.mainactivity.Rutas.Model.Ruta;
import com.gestioncobranza.mainactivity.Rutas.Presenter.RutasPresenterImpl;
import com.gestioncobranza.mainactivity.Rutas.Rutas;

import java.util.ArrayList;

public class DetailRutasActivity extends AppCompatActivity implements Rutas.view {

    private Rutas.presenter rutasPresenter;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_rutas);
        Intent intent = getIntent();
        id = intent.getIntExtra("id",0);
        rutasPresenter = new RutasPresenterImpl(this);
        initView();
        getItem(id);

    }

    private void initView() {
    }


    @Override
    public void showItem(Ruta ruta) {

    }

    @Override
    public void getItem(int id) {
        rutasPresenter.getItem(id);
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

    @Override
    public void showData(ArrayList<Ruta> rutas) {

    }
}
