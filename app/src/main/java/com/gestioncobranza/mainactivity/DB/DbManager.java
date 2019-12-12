package com.gestioncobranza.mainactivity.DB;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import com.gestioncobranza.mainactivity.API.ApiClient;
import com.gestioncobranza.mainactivity.API.ApiService;
import com.gestioncobranza.mainactivity.API.HolderApi;
import com.gestioncobranza.mainactivity.Clientes.Model.ClientesRepository;
import com.gestioncobranza.mainactivity.Clientes.Model.MunicipiosRepository;
import com.gestioncobranza.mainactivity.Cobros.Model.Repository.CobrosRepository;
import com.gestioncobranza.mainactivity.Facturas.Model.Repository.AbonosFacturasRepository;
import com.gestioncobranza.mainactivity.Facturas.Model.Repository.FacturasRepository;
import com.gestioncobranza.mainactivity.Facturas.Model.Repository.ProductoFacturasRepository;
import com.gestioncobranza.mainactivity.Login.Model.LoginRepository;
import com.gestioncobranza.mainactivity.Productos.Model.EntregadasRepository;
import com.gestioncobranza.mainactivity.Productos.Model.ProductosRepository;
import com.gestioncobranza.mainactivity.Rutas.Model.Ruta;
import com.gestioncobranza.mainactivity.Rutas.Model.RutasRepositoryImpl;

import java.util.ArrayList;

public class DbManager extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "creditos.db";
    private static final int VERSION = 16;

    private final String[] COLUMNAS;
    private final String TABLA;
    public final SharedPreferences preferences;
    public final SharedPreferences.Editor editorPreferences;
    public final HolderApi holderApi;
    public final ApiService apiService;
    public final String TAG = "DBMANAGER";
    public String token;
    public String username;

    public DbManager(Context context,String tabla, String[] columnas) {
        super(context, DATABASE_NAME,null, VERSION);
        this.TABLA = tabla;
        this.COLUMNAS = columnas;
        this.preferences = context.getSharedPreferences(LoginRepository.PREFERENCES_USER_NAME, Context.MODE_PRIVATE);
        this.editorPreferences = preferences.edit();

        //API
        this.holderApi = new HolderApi();
        this.apiService = ApiClient.getClient(context,holderApi);
        this.holderApi.setApiService(apiService);

        this.username = preferences.getString("email","");
    }

    public void insert(ContentValues values){

        getWritableDatabase().insert(TABLA,null,values);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        createTable(LoginRepository.UserEntry.TABLE, LoginRepository.UserEntry.COLUMNAS,db);
        createTable(MunicipiosRepository.MunicipioEntry.TABLE_NAME, MunicipiosRepository.MunicipioEntry.COLUMNAS,db);

        createTable(ClientesRepository.ClienteEntry.TABLE_NAME, ClientesRepository.ClienteEntry.COLUMNAS,db);

        createTable(FacturasRepository.FacturasEntry.TABLE,FacturasRepository.FacturasEntry.COLUMNAS,db);
        createTable(AbonosFacturasRepository.AbonosEntry.TABLE,AbonosFacturasRepository.AbonosEntry.COLUMNAS,db);
        createTable(ProductoFacturasRepository.ProductosFacturasEntry.TABLE, ProductoFacturasRepository.ProductosFacturasEntry.COLUMNAS,db);

        createTable(ProductosRepository.ProductosEntry.TABLA, ProductosRepository.ProductosEntry.COLUMNAS,db);

        createTable(CobrosRepository.CobrosEntry.TABLE, FacturasRepository.FacturasEntry.COLUMNAS,db);
        createTable(CobrosRepository.CobrosItemEntry.TABLE, CobrosRepository.CobrosItemEntry.COLUMNAS,db);

        createTable(EntregadasRepository.EntregadasEntry.TABLA, EntregadasRepository.EntregadasEntry.COLUMNAS,db);

        createTable(RutasRepositoryImpl.RutasEntry.TABLE, RutasRepositoryImpl.RutasEntry.COLUMNAS,db);
        createTable(RutasRepositoryImpl.ItemsRutasEntry.TABLE, RutasRepositoryImpl.ItemsRutasEntry.COLUMNAS,db);

        ContentValues values = new ContentValues();
        values.put("_id", Ruta.CLIENTES_SIN_RUTAS_ID);
        values.put("nombre", Ruta.CLIENTES_SIN_RUTAS_NOMBRE);
        values.put("municipio_id", 0);

        saveDefaultData(RutasRepositoryImpl.RutasEntry.TABLE,values,db);

    }

    private void saveDefaultData(String table, ContentValues values, SQLiteDatabase db) {
        values.put("usuario","user");
        Log.d(TAG, "saveDefaultData: GUARDANDO RUTA INICIAL" + values.get("_id") );
        db.insert(table,null,values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        deleteTables(LoginRepository.UserEntry.TABLE,db);
        deleteTables(MunicipiosRepository.MunicipioEntry.TABLE_NAME,db);

        deleteTables(ClientesRepository.ClienteEntry.TABLE_NAME,db);

        deleteTables(FacturasRepository.FacturasEntry.TABLE,db);
        deleteTables(AbonosFacturasRepository.AbonosEntry.TABLE,db);
        deleteTables(ProductoFacturasRepository.ProductosFacturasEntry.TABLE,db);

        deleteTables(ProductosRepository.ProductosEntry.TABLA,db);

        deleteTables(CobrosRepository.CobrosEntry.TABLE,db);
        deleteTables(CobrosRepository.CobrosItemEntry.TABLE,db);

        deleteTables(EntregadasRepository.EntregadasEntry.TABLA,db);

        deleteTables(RutasRepositoryImpl.RutasEntry.TABLE,db);
        deleteTables(RutasRepositoryImpl.ItemsRutasEntry.TABLE,db);

        onCreate(db);
    }

    public void checkData(String[] ids){

        String sql = "SELECT * FROM " + TABLA + " WHERE _id  NOT IN (";

         for(int i = 0; i  < ids.length; i++) {
            sql += "?";
            sql += (i+1) == ids.length ? "" : ",";
         }

        sql += ")";

        Cursor cursor = getReadableDatabase().rawQuery( sql , ids);

        if(cursor != null ) cursor.moveToFirst();

        while(!cursor.isAfterLast()) {
            getWritableDatabase().delete(TABLA,"_id = ?",new String[]{ String.valueOf(getFieldI(cursor,"_id"))});
            cursor.moveToNext();
        }

    }

    public void saveData(ContentValues values){

        values.put("usuario",username);

        String id = values.get("_id") != null ?  values.get("_id").toString() : "" ;

        Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM " + TABLA + " WHERE _id  = ?" , new String[]{id});

        if(cursor.getCount() > 0 ){
            getWritableDatabase().update(TABLA,values,"_id = ?",new String[]{ id});
        }else{
            getWritableDatabase().insert(TABLA, null, values);
        }
    }

    public void createTable( String Nombre, String [] Columnas,SQLiteDatabase db){
        String sqlCreateTable = "CREATE TABLE " + Nombre + " (" + BaseColumns._ID + " integer primary key";
        for (int i = 0; i< Columnas.length; i++) {
            sqlCreateTable+= " ," + Columnas[i];
        }
        sqlCreateTable+=" ) ";
        db.execSQL(sqlCreateTable);
    }

    private void deleteTables(String tableName,SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + tableName);
    }

    public String getField(Cursor cursor,String field){
        return cursor.getString(cursor.getColumnIndex(field));
    }

    public int getFieldI(Cursor cursor,String field){
        return cursor.getInt(cursor.getColumnIndex(field));
    }

    protected void updateData(ContentValues values) {
        getWritableDatabase().update(TABLA,values, "username = ? AND _id = ?", new String[]{ username,values.get("_id").toString()});
    }
}
