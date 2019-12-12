package com.gestioncobranza.mainactivity.Clientes.Model;

import android.content.ContentValues;
import android.database.Cursor;
import android.provider.BaseColumns;
import android.util.Log;

import com.gestioncobranza.mainactivity.Clientes.Clientes;
import com.gestioncobranza.mainactivity.DB.ClienteDB;
import com.gestioncobranza.mainactivity.DB.DbManager;
import com.gestioncobranza.mainactivity.DB.TablaBase;
import com.gestioncobranza.mainactivity.MainInterface;
import com.gestioncobranza.mainactivity.Rutas.Model.Ruta;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClientesRepository extends DbManager implements Clientes.repository {

    private static final String TABLE_NAME = ClienteEntry.TABLE_NAME;
    private static final String[] COLUMNAS = ClienteEntry.COLUMNAS;
    private final Clientes.presenter clientesPresenter;
    public static  final String TAG = "CLIENTES REPOSITORY";
    private final MunicipiosRepository municipioRepository;

    public ClientesRepository(Clientes.presenter clientesPresenter) {
        super(clientesPresenter.getView(),TABLE_NAME,COLUMNAS);
        this.clientesPresenter = clientesPresenter;
        this.municipioRepository = new MunicipiosRepository(clientesPresenter);

    }


    public void save (ArrayList<ClienteDB.Cliente> clientes){

        String [] ids = new String[clientes.size()];

        for (int i = 0; i < clientes.size();i++) {
                ids[i] = String.valueOf(clientes.get(i).getId());
        }

        super.checkData(ids);

        for(int i = 0; i < clientes.size(); i++){
            ContentValues values = new ContentValues();
            ClienteDB.Cliente cliente = clientes.get(i);

            values.put("_id",cliente.getId());
            values.put("cod",cliente.getCod());
            values.put("nombre",cliente.getNombre());
            values.put("email",cliente.getEmail());
            values.put("telefono",cliente.getTelefono());
            values.put("cedula",cliente.getCedula());
            values.put("direccion",cliente.getDireccion());
            values.put("adicional",cliente.getAdicional());
            values.put("ruta_id",cliente.getRuta());
            values.put("municipio_id",cliente.getMunicipioId());

            municipioRepository.saveMunicipio(cliente.getMunicipio());
            super.saveData(values);
        }
    }



    @Override
    public void addCliente(Cliente cliente) {

        ContentValues values = new ContentValues();
        
        values.put("cod",cliente.getCod());
        values.put("nombre",cliente.getNombre());
        values.put("email",cliente.getEmail());
        values.put("telefono",cliente.getTelefono());
        values.put("cedula",cliente.getCedula());
        values.put("adicional",cliente.getInformacion_adicional());
        values.put("ruta_id",cliente.getRuta().getId());
        values.put("municipio_id",cliente.getMunicipio_id());

        super.saveData(values);
    }

    @Override
    public void getClientesByRutas(int id, String query) {
        Cursor cursor = super.getReadableDatabase().rawQuery(
                "SELECT clientes.*, municipios.nombre as municipio_nombre,rutas.nombre as ruta_nombre FROM clientes " +
                "INNER JOIN municipios ON municipios._id = clientes.municipio_id " +
                "INNER JOIN rutas ON rutas._id = clientes.ruta_id " +
                "WHERE ruta_id = ? AND clientes.nombre LIKE ? LIMIT 0,5" , new String[]{String.valueOf(id), "%" + query + "%"});


        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Ruta> rutas = new ArrayList<>();


        if(cursor != null) cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            Log.d("Clientes WHILE",getFieldI(cursor,"_id") + "");
            clientes.add(getClienteFromCursor(cursor));
            cursor.moveToNext();
        }

        rutas.add(new Ruta(1,"ruta",clientes));
        clientesPresenter.showClientes(rutas);
    }

    @Override
    public void getDatos() {
        Cursor cursor = super.getReadableDatabase().rawQuery("SELECT * FROM rutas" , null);
        if(cursor != null) cursor.moveToFirst();

        ArrayList<Ruta> rutas = new ArrayList<>();

        while(!cursor.isAfterLast()){
            Log.d("Rutas WHILE",getFieldI(cursor,"_id") + "");
            ArrayList<Cliente> clientes = getClientesByRuta(getFieldI(cursor,"_id"));

            if(clientes.size() > 0){
                rutas.add(new Ruta(getFieldI(cursor,"_id"),getField(cursor,"nombre"),clientes));
            }
            cursor.moveToNext();
        }

        clientesPresenter.showClientes(rutas);
    }

    @Override
    public void getDatos(String query) {
        Cursor c = super.getReadableDatabase().query(ClienteEntry.TABLE_NAME,null,"nombre = ? ",new String[]{ "%" + query +"%", username },null,null, null );
    }

    @Override
    public void getDatosApi(MainInterface.onResult onResult) {
        Call<ClienteDB.Clientes> call = apiService.getClientes("CL");

        call.enqueue(new Callback<ClienteDB.Clientes>() {
            @Override
            public void onResponse(Call<ClienteDB.Clientes> call, Response<ClienteDB.Clientes> response) {
                if(response.isSuccessful()){
                    save(response.body().getClientList());
                }
                onResult.doAction();
            }

            @Override
            public void onFailure(Call<ClienteDB.Clientes> call, Throwable t) {
                onResult.doAction();
            }
        });

        onResult.doAction();
    }

    @Override
    public void syncData() {
        Cursor c = super.getReadableDatabase().query(ClienteEntry.TABLE_NAME,null,"sincronizado = 0 AND usuario = ?",new String[]{ username },null,null, null );
    }

    @Override
    public void getItem(int id) {

    }

    public ArrayList<Cliente> getClientesByRuta(int ruta_id){

        Cursor cursor = super.getReadableDatabase().rawQuery("SELECT clientes.*, municipios.nombre as municipio_nombre,rutas.nombre as ruta_nombre FROM clientes " +
                "INNER JOIN municipios ON municipios._id = clientes.municipio_id " +
                "INNER JOIN rutas ON rutas._id = clientes.ruta_id " +
                "WHERE ruta_id = ? LIMIT 0,5" , new String[]{String.valueOf(ruta_id)});


        ArrayList<Cliente> clientes = new ArrayList<>();

        if(cursor != null) cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            Log.d("Clientes WHILE",getFieldI(cursor,"_id") + "");
            clientes.add(getClienteFromCursor(cursor));
            cursor.moveToNext();
        }

        return clientes;
    }

    public Cliente getClienteFromCursor(Cursor cursor){

      return    new Cliente(
                getFieldI(cursor,"_id"),
                getFieldI(cursor,"cod"),
                getField(cursor,"nombre"),
                getField(cursor,"email"),
                getField(cursor,"cedula"),
                getField(cursor,"direccion"),
                getField(cursor,"deuda"),
                getField(cursor,"telefono"),
                getField(cursor,"adicional"),
                new Ruta(getFieldI(cursor,"ruta_id"),getField(cursor,"ruta_nombre")),
                getFieldI(cursor,"municipio_id")
        );
    }

    public static final class ClienteEntry extends TablaBase implements BaseColumns {
        public static final String TABLE_NAME = "clientes";

        public static final String COLUMNA_COD = "cod int(10) NOT NULL";
        public static final String COLUMNA_CEDULA = "cedula varchar(150) NOT NULL";
        public static final String COLUMNA_DIRECCION = "direccion varchar(150) NOT NULL";
        public static final String COLUMNA_ADICIONAL = "adicional varchar(150) NOT NULL";
        public static final String COLUMNA_EMAIL = "email varchar(150) NOT NULL";
        public static final String COLUMNA_DEUDA = "deuda varchar(150) NULL DEFAULT 0";
        public static final String COLUMNA_TELEFONO = "telefono varchar(150) NOT NULL";
        public static final String COLUMNA_RUTA_ID = "ruta_id int(10) NOT NULL";

        public static final String[] COLUMNAS = new String[]{COLUMNA_COD,COLUMNA_USUARIO_ID,COLUMNA_NOMBRE,COLUMNA_CEDULA,COLUMNA_DIRECCION,COLUMNA_ADICIONAL,COLUMNA_EMAIL,COLUMNA_TELEFONO,COLUMNA_MUNICIPIO,COLUMNA_DEUDA,COLUMNA_RUTA_ID,COLUMNA_SINCRONIZADO };
    }
}
