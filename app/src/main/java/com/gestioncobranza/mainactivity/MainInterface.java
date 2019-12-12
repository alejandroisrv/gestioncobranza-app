package com.gestioncobranza.mainactivity;

import android.content.ContentValues;
import android.content.Context;

public interface MainInterface {

    interface view{
        void getDatos();
        void getDatosApi();
        void syncData();
        void getItem(int id);
        Context getContext();
        void showLoading(String text);
        void showAlert(String titulo,String text);
        void stopLoading();
        void stopLoading(String text);
    }

    interface presenter{
        Context getView();
        void getDatos();
        void getDatos(String query);
        void getItem(int id);
        void getDatosApi(onResult onResult);
        void syncData();
        void showLoading(String text);
        void showAlert(String titulo,String text);
        void stopLoading();
        void stopLoading(String text);

    }

    interface interactor{
        void getDatos();
        void getDatos(String query);
        void getItem(int id);
        void getDatosApi(onResult onResult);
        void syncData();
    }

    interface repository{
        void getDatos();
        void getDatos(String query);
        void getDatosApi(onResult onResult);
        void getItem(int id);
        void syncData();
    }


    interface DataManager{
        void getDataApi();
    }

    interface onResult {
        void doAction();
    }

}
