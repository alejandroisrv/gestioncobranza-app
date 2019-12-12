package com.gestioncobranza.mainactivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.gestioncobranza.mainactivity.Clientes.View.ClientesFragment;
import com.gestioncobranza.mainactivity.Cobros.View.CobrosFragment;
import com.gestioncobranza.mainactivity.Facturas.View.FacturasFragment;
import com.gestioncobranza.mainactivity.Login.Login;
import com.gestioncobranza.mainactivity.Login.Model.User;
import com.gestioncobranza.mainactivity.Login.Presenter.LoginPresenter;
import com.gestioncobranza.mainactivity.Login.View.LoginActivity;
import com.gestioncobranza.mainactivity.Productos.View.ProductoFragment;
import com.gestioncobranza.mainactivity.Rutas.View.RutasFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Login.view {
    private TextView mTextMessage;
    private Fragment clientesFragment = new ClientesFragment();
    private Fragment cobrosFragment = new CobrosFragment();
    private Fragment facturasFragment = new FacturasFragment();
    private Fragment rutasFragment = new RutasFragment();
    private Fragment productosFragment  = new ProductoFragment();
    Fragment active = clientesFragment;

    final FragmentManager fm = getSupportFragmentManager();
    private Toolbar toolbar;
    private int PERMISO_CODE = 200;
    private DrawerLayout drawerLayout;
    TextView navbar_name;
    TextView navbar_email;
    TextView navbar_role;
    private Login.presenter loginPresenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        loginPresenter = new LoginPresenter(this);

        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        configureNavigationDrawer();
        fm.beginTransaction().add(R.id.main_container, rutasFragment, "Rutas Fragment").hide(rutasFragment).commit();
        fm.beginTransaction().add(R.id.main_container, cobrosFragment, "Cobros Fragment").hide(cobrosFragment).commit();
        fm.beginTransaction().add(R.id.main_container, facturasFragment, "Facturas fragment").hide(facturasFragment).commit();
        fm.beginTransaction().add(R.id.main_container, productosFragment, "Productos Fragment").hide(productosFragment).commit();
        fm.beginTransaction().add(R.id.main_container,active, "Clientes Fragment").commit();
        getSupportActionBar().setTitle("Clientes");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.clientes_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
                switch (item.getItemId()) {

                    case R.id.nav_clientes:
                        fm.beginTransaction().hide(active).show(clientesFragment).commit();
                        active = clientesFragment;
                        getSupportActionBar().setTitle("Clientes");

                        return true;

                    case R.id.nav_jornadas:
                        fm.beginTransaction().hide(active).show(cobrosFragment).commit();
                        getSupportActionBar().setTitle("Jornadas de cobros");
                        active = cobrosFragment;
                        return true;

                    case R.id.nav_facturas:
                        fm.beginTransaction().hide(active).show(facturasFragment).commit();
                        getSupportActionBar().setTitle("Facturas");
                        active = facturasFragment;
                        return true;

                    case R.id.nav_productos:
                        fm.beginTransaction().hide(active).show(productosFragment).commit();
                        active = productosFragment;
                        getSupportActionBar().setTitle("Productos");
                        return true;

                    case R.id.nav_rutas:
                        fm.beginTransaction().hide(active).show(rutasFragment).commit();
                        active = rutasFragment;
                        getSupportActionBar().setTitle("Rutas");
                        return true;

                }
                return false;
            };


    private void configureNavigationDrawer() {
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navView = findViewById(R.id.navigation);
        View navbar_header =  navView.getHeaderView(0);
        navbar_name = navbar_header.findViewById(R.id.navbar_name);
        navbar_email = navbar_header.findViewById(R.id.navbar_email);

        navView.setNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()){
                case R.id.nav_logout: logOut(); break;
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });

    }

    @Override
    public void getUser() {
        loginPresenter.getUser();
    }

    @Override
    public void showUser(User user) {
        navbar_name.setText(user.getName());
        navbar_email.setText(user.getEmail());
        navbar_role.setText(user.getAtributeRole());
        Log.d("MAINACTIVITY", "showUser: " + user.getEmail());

    }

    @Override
    public void goLogin() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void goHome() {

    }

    @Override
    public void logIn(String user, String password) {

    }

    @Override
    public void logOut() {
        loginPresenter.logOut();
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
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,  @NonNull int[] grantResults){
        super.onRequestPermissionsResult(requestCode,permissions,grantResults);
        if (requestCode == PERMISO_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(MainActivity.this,"Permission Granted",Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this,"Permission Denied",Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public boolean checkPermission(String writeExternalStorage, int code) {
        return false;
    }
}
