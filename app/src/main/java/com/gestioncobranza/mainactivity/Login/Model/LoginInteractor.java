package com.gestioncobranza.mainactivity.Login.Model;

import com.gestioncobranza.mainactivity.Login.Login;
import com.gestioncobranza.mainactivity.Login.Presenter.LoginPresenter;

import java.io.IOException;

public class LoginInteractor implements Login.interactor {
    private final Login.repository loginRepository;

    public LoginInteractor(Login.presenter loginPresenter) {
        this.loginRepository = new LoginRepository(loginPresenter);
    }

    @Override
    public void logIn(String user, String password) {
        loginRepository.logIn(user,password);
    }

    @Override
    public void logOut() {
        loginRepository.logOut();
    }

    @Override
    public void getUser() {
        loginRepository.getUser();
    }

    @Override
    public boolean isLogIn() {
        return loginRepository.isLogIn();
    }
}
