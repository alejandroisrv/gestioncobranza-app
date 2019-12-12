package com.gestioncobranza.mainactivity.API;

import android.content.Context;
import android.content.SharedPreferences;

import com.gestioncobranza.mainactivity.Login.Model.LoginRepository;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpClientInstance {

    public static class Builder {

        Context context;
        HolderApi holderApi;

        public Builder(Context context, HolderApi holderApi) {
            this.context = context;
            this.holderApi = holderApi;
        }

        public OkHttpClient build() {
            TokenInterceptor authenticator = new TokenInterceptor(context, holderApi);

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .addInterceptor(
                            chain -> {

                                Request.Builder requestBuilder = chain.request().newBuilder().addHeader("Content-Type","application/json");
                                SharedPreferences settings = context.getSharedPreferences(LoginRepository.PREFERENCES_USER_NAME, Context.MODE_PRIVATE);

                                String token = settings.getString(LoginRepository.PREFERENCES_TOKEN_KEY, null);

                                if (token != null) {
                                    requestBuilder.addHeader("Authorization", "Bearer " + token);
                                }

                                return chain.proceed(requestBuilder.build());

                            }
                    );

            okHttpClientBuilder.authenticator(authenticator);

            return okHttpClientBuilder.build();
        }
    }


}
