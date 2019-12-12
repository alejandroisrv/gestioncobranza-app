package com.gestioncobranza.mainactivity.Login.Model;

import android.Manifest;
import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;

import com.gestioncobranza.mainactivity.DB.DbManager;
import com.gestioncobranza.mainactivity.DB.MyResponse;
import com.gestioncobranza.mainactivity.DB.UserReponse;
import com.gestioncobranza.mainactivity.Login.Login;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepository extends DbManager implements Login.repository {
    public static final String PREFERENCES_TOKEN_KEY = "token";
    private static final String TABLE = UserEntry.TABLE;
    private static final String[] COLUMNAS = UserEntry.COLUMNAS ;
    private final Login.presenter loginPresenter;
    public static final String PREFERENCES_USER_NAME = "user_preferences";
    public static String token;
    private String TAG = "LOGIN REPOSiTORY";

    public LoginRepository(Login.presenter loginPresenter) {
        super(loginPresenter.getView(),TABLE,COLUMNAS);
        this.loginPresenter = loginPresenter;

    }

    @Override
    public void logIn(String user, String password) {
        loginApi(user,password);
    }

    @Override
    public void logOut() {
        editorPreferences.putBoolean("auth", false);
        editorPreferences.putString("token","");
        editorPreferences.remove("email");
        editorPreferences.remove("password");
        editorPreferences.commit();
    }

    @Override
    public void getUser() {

        Log.d(TAG, "getUser: " + username);
        Cursor cursor = super.getReadableDatabase().query(UserEntry.TABLE,null,"usuario = ? ", new String[]{ username },null,null,null);

        if(cursor.getCount() == 0){
            logOut();
            loginPresenter.goLogin();
            return;
        }

        if (cursor != null) cursor.moveToFirst();
        User user = new User(getFieldI(cursor,"_id"),
                getField(cursor,"name"),
                getField(cursor,"usuario"),
                getFieldI(cursor,"role")

        );

        cursor.close();

        loginPresenter.showUser(user);

    }

    @Override
    public boolean isLogIn() {
        return preferences.getBoolean("auth",false);
    }

    public void loginApi(String user, String password){

        Call<UserReponse> call = apiService.logIn(user,password);
        loginPresenter.showLoading();
        Log.d(TAG,"LOGIN API");
        call.enqueue(new Callback<UserReponse>() {
            @Override
            public void onResponse(Call<UserReponse> call, Response<UserReponse> response) {
                if(response.isSuccessful()){
                    UserReponse loginResponse = response.body();
                    if(loginResponse.getSuccess()){
                        setToken(loginResponse,password);
                        loginPresenter.goHome();
                    }
                }

            }

            @Override
            public void onFailure(Call<UserReponse> call, Throwable t) {
                Log.d(TAG,  "FALLO SOLICITUD");
            }
        });
    }

    private void setToken(UserReponse loginResponse, String password) {

        User user = loginResponse.getUser();
        int exist = super.getReadableDatabase().rawQuery( "SELECT * FROM usuarios WHERE username = ? ",new String[]{ loginResponse.getUser().getEmail() }).getCount();
        ContentValues values = new ContentValues();
        values.put("name", user.getName());
        values.put("username", user.getEmail());
        values.put("email",user.getCorreo());
        values.put("password", password);
        values.put("role", user.getRole());

        editorPreferences.putString(PREFERENCES_TOKEN_KEY, loginResponse.getToken());
        editorPreferences.putString("email", loginResponse.getUser().getEmail());
        editorPreferences.putString("password",password);
        editorPreferences.putBoolean("auth",true);
        editorPreferences.commit();

        //editorPreferences.putBoolean("isFirst",exist == 0);


        if(exist == 0) {
            super.getWritableDatabase().insert(UserEntry.TABLE,null,values);
        }else{
          super.getWritableDatabase().update(UserEntry.TABLE,values,"username = ?",new String[]{user.getEmail()});
        }

        editorPreferences.commit();
        super.close();

    }


    public String getToken() {
        token = preferences.getString("token","");
        return token;
    }

    public static final class UserEntry{
        public static final String TABLE = "usuarios";

        public static final String COLUMNA_NOMBRE = "name varchar(255) NOT NULL";
        public static final String COLUMNA_USER = "username varchar(150) NOT NULL";
        public static final String COLUMNA_EMAIL = "email varchar(150) NOT NULL";
        public static final String COLUMNA_PASSWORD = "password varchar(150) NOT NULL";
        public static final String COLUMNA_ROL = "role int(150) NOT NULL";

        public static  final String[] COLUMNAS = new String[]{
                                                                COLUMNA_NOMBRE,
                                                                COLUMNA_PASSWORD,
                                                                COLUMNA_USER,
                                                                COLUMNA_EMAIL,
                                                                COLUMNA_ROL
                                                            };

    }
}
