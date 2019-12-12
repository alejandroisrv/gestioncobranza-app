package com.gestioncobranza.mainactivity.API;

import androidx.annotation.Keep;

import com.gestioncobranza.mainactivity.DB.ClienteDB;
import com.gestioncobranza.mainactivity.DB.CobroDB;
import com.gestioncobranza.mainactivity.DB.FacturaDB;
import com.gestioncobranza.mainactivity.DB.MyResponse;
import com.gestioncobranza.mainactivity.DB.ProductoDB;
import com.gestioncobranza.mainactivity.DB.RutaDB;
import com.gestioncobranza.mainactivity.DB.UserReponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

@Keep
public interface ApiService {

    @FormUrlEncoded
    @POST("auth/login")
    Call<UserReponse> logIn(@Field("email") String email, @Field("password") String password);

    @POST("auth/logout")
    Call<MyResponse.logout> logOut();

    @GET("items")
    Call<RutaDB> getRutas(@Query("entidad") String entidad);

    @GET("items")
    Call<ClienteDB.Clientes> getClientes(@Query("entidad") String entidad);

    @GET("items")
    Call<FacturaDB> getFacturas(@Query("entidad") String entidad);

    @GET("items")
    Call<CobroDB> getCobros(@Query("entidad") String entidad);

    @GET("items")
    Call<ProductoDB> getProductos(@Query("entidad") String entidad);

}

