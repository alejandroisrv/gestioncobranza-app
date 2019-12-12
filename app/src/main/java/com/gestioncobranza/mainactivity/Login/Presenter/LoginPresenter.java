package com.gestioncobranza.mainactivity.Login.Presenter;

import android.content.Context;

import com.gestioncobranza.mainactivity.Login.Login;
import com.gestioncobranza.mainactivity.Login.Model.LoginInteractor;
import com.gestioncobranza.mainactivity.Login.Model.User;
import com.gestioncobranza.mainactivity.Login.View.LoginActivity;

public class LoginPresenter implements Login.presenter {

    private final Login.view loginView;
    private final Login.interactor loginInteractor;

    public LoginPresenter(Login.view loginActivity) {
        this.loginView = loginActivity;
        loginInteractor = new LoginInteractor(this);
    }

    @Override
    public Context getView() {
        return loginView.getContext();
    }

    @Override
    public void logIn(String user, String password) {
        loginInteractor.logIn(user,password);
    }

    @Override
    public void logOut() {
        loginInteractor.logOut();
    }

    @Override
    public void goHome() {
        loginView.goHome();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showAlert(String titulo, String text) {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public boolean isLogIn() {
        return loginInteractor.isLogIn();
    }

    @Override
    public void getUser() {
        loginInteractor.getUser();
    }

    @Override
    public void showUser(User user) {
        loginView.showUser(user);
    }

    @Override
    public boolean checkPermission(String writeExternalStorage, int code) {
        return loginView.checkPermission(writeExternalStorage,code);
    }

    @Override
    public void goLogin() {

    }
}
