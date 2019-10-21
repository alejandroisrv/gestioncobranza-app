package com.gestioncobranza.mainactivity.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.gestioncobranza.mainactivity.Clientes.Model.ClienteRepository;

public class DbManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "gestioncobranza";
    private static final int VERSION = 1;
    private final String[] COLUMNAS;
    private final String TABLA;

    public DbManager(Context context,String tabla, String[] columnas) {
        super(context, DATABASE_NAME,null, VERSION);
        this.TABLA = tabla;
        this.COLUMNAS = columnas;
    }

    public void saveData(ContentValues values){
        getWritableDatabase().insert(TABLA,null,values);
    }

    public void createTable(String TABLE_NAME, String[] COLUMNAS, SQLiteDatabase db){

        String SqlCreate = "CREATE TABLE " + TABLE_NAME +"(";
        for (int i = 0; COLUMNAS.length < i; i++){
            SqlCreate +=  COLUMNAS[i] + " ,";
        }
        SqlCreate += ")";

        db.execSQL(SqlCreate);
    }

    private void deleteTables(SQLiteDatabase db, String tableName) {
        db.execSQL("DROP TABLE IF EXISTS " + tableName);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTable(ClienteRepository.ClienteEntry.TABLE_NAME, ClienteRepository.ClienteEntry.COLUMNAS,db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        deleteTables(db, ClienteRepository.ClienteEntry.TABLE_NAME);
        onCreate(db);
    }

}
