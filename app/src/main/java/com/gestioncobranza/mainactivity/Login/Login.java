package com.gestioncobranza.mainactivity.Login;

import android.content.Context;

import com.gestioncobranza.mainactivity.Login.Model.User;
import com.gestioncobranza.mainactivity.MainInterface;

import java.io.IOException;

public interface Login  {
    interface  view {
        Context getContext();
        void goLogin();
        void goHome();
        void logIn(String user,String password);
        void logOut();
        void showLoading();
        void showAlert(String titulo,String text);
        void stopLoading();
        void getUser();
        void showUser(User user);
        boolean checkPermission(String writeExternalStorage, int code);
    }

    interface presenter {
        Context getView();
        void logIn(String user,String password);
        void logOut();
        void goHome();
        void showLoading();
        void showAlert(String titulo,String text);
        void stopLoading();
        boolean isLogIn();
        void getUser();
        void showUser(User user);
        boolean checkPermission(String writeExternalStorage, int code);
        void goLogin();
    }
    interface interactor {
        void logIn(String user,String password);
        void logOut();
        void getUser();
        boolean isLogIn();
    }

    interface  repository {
        void logIn(String user,String password);
        void logOut();
        void getUser();
        boolean isLogIn();
    }
}
