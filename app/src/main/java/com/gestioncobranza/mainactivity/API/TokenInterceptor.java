package com.gestioncobranza.mainactivity.API;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.gestioncobranza.mainactivity.DB.UserReponse;
import com.gestioncobranza.mainactivity.Login.Model.LoginRepository;
import com.gestioncobranza.mainactivity.Login.View.LoginActivity;

import java.io.IOException;

import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

public class TokenInterceptor implements Authenticator {

    public final Context context;
    public final HolderApi myServiceHolder;

    public TokenInterceptor(Context context, HolderApi myServiceHolder) {
        this.context = context;
        this.myServiceHolder = myServiceHolder;
    }

    @Override
    public Request authenticate(Route route, Response response) throws IOException {

        if (myServiceHolder == null) {
            return null;
        }
        SharedPreferences settings = context.getSharedPreferences(LoginRepository.PREFERENCES_USER_NAME, Context.MODE_PRIVATE);


        if (response.code() == 401 && settings.getBoolean("auth",false)) {

            Log.d("TOKEN","TOKEN INVALIDO");
            SharedPreferences.Editor editor = settings.edit();

            retrofit2.Response retrofitResponse = myServiceHolder.getApiService().logIn(settings.getString("email",null),settings.getString("password",null)).execute();

            if (retrofitResponse.code() == 403){
                Log.d("TOKEN","CREDENCIALES CAMBIARON");
                deleteUser(editor);
                Intent intent = new Intent(context, LoginActivity.class);
                intent.putExtra("credentialsInvalid",true);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }

            if(retrofitResponse.isSuccessful()){
                Log.d("TOKEN","REFRESCO EXITOSO");
                UserReponse loginResponse = (UserReponse) retrofitResponse.body();
                String newAccessToken = loginResponse.getToken();

                editor.putString(LoginRepository.PREFERENCES_TOKEN_KEY,newAccessToken);
                editor.commit();

                return response.request().newBuilder()
                        .header("Authorization", "Bearer " + newAccessToken)
                        .build();
            }

        }

        return response.request().newBuilder().build();
    }

    private void deleteUser(SharedPreferences.Editor editor) {
        editor.putBoolean("auth", false);
        editor.remove("email");
        editor.remove("password");
        editor.commit();
    }

}
