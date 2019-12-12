package com.gestioncobranza.mainactivity.Login.View;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gestioncobranza.mainactivity.Login.Login;
import com.gestioncobranza.mainactivity.Login.Model.User;
import com.gestioncobranza.mainactivity.Login.Presenter.LoginPresenter;
import com.gestioncobranza.mainactivity.MainActivity;
import com.gestioncobranza.mainactivity.R;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity implements Login.view {

    private Login.presenter loginPresenter;
    private Button btnLogin;
    private TextInputEditText passwordEdit;
    private TextInputEditText userEditText;
    private int PERMISO_CODE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorGrayBackground));

        loginPresenter = new LoginPresenter(this);
        if(loginPresenter.isLogIn()){
            goHome();
        }
        initView();
        btnLogin.setOnClickListener( v-> logIn(userEditText.getText().toString(),passwordEdit.getText().toString()));
    }

    public void initView(){
        userEditText = findViewById(R.id.login_email);
        passwordEdit = findViewById(R.id.login_password);
        btnLogin = findViewById(R.id.btnLogin);

    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void goLogin() {

    }

    @Override
    public void goHome() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void logIn(String user, String password) {
        loginPresenter.logIn(user, password);
    }

    @Override
    public void logOut() {

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
    public void getUser() {

    }

    @Override
    public void showUser(User user) {

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public boolean checkPermission(String writeExternalStorage, int code) {
        if (getContext().checkSelfPermission(writeExternalStorage) != PackageManager.PERMISSION_GRANTED) {
            if (!ActivityCompat.shouldShowRequestPermissionRationale(this, writeExternalStorage)) {
                ActivityCompat.requestPermissions(this, new String[]{writeExternalStorage}, code);
            }
        } else {
            return true;
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        super.onRequestPermissionsResult(requestCode,permissions,grantResults);
        if (requestCode == PERMISO_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(LoginActivity.this,"Permission Granted",Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(LoginActivity.this,"Permission Denied",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
