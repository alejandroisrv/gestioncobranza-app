package com.gestioncobranza.mainactivity;

import android.os.Bundle;

import com.gestioncobranza.mainactivity.Clientes.View.ClientesFragment;
import com.gestioncobranza.mainactivity.Cobros.View.CobrosFragment;
import com.gestioncobranza.mainactivity.Facturas.FacturasFragment;
import com.gestioncobranza.mainactivity.Productos.ProductoFragment;
import com.gestioncobranza.mainactivity.Rutas.View.RutasFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private Fragment clientesFragment = new ClientesFragment();
    private Fragment cobrosFragment = new CobrosFragment();
    private Fragment facturasFragment = new FacturasFragment();
    private Fragment rutasFragment = new RutasFragment();
    private Fragment productosFragment  = new ProductoFragment();
    Fragment active = clientesFragment;

    final FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fm.beginTransaction().add(R.id.main_container, rutasFragment, "Rutas Fragment").hide(rutasFragment).commit();
        fm.beginTransaction().add(R.id.main_container, cobrosFragment, "Cobros Fragment").hide(cobrosFragment).commit();
        fm.beginTransaction().add(R.id.main_container, facturasFragment, "Facturas fragment").hide(facturasFragment).commit();
        fm.beginTransaction().add(R.id.main_container, productosFragment, "Productos Fragment").hide(productosFragment).commit();
        fm.beginTransaction().add(R.id.main_container,active, "Clientes Fragment").commit();
        getSupportActionBar().setTitle("Clientes");

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {

                case R.id.nav_clientes:
                    fm.beginTransaction().hide(active).show(rutasFragment).commit();
                    active = rutasFragment;
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
        }
    };

}
