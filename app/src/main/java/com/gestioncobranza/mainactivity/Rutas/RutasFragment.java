package com.gestioncobranza.mainactivity.Rutas;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gestioncobranza.mainactivity.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RutasFragment extends Fragment {


    public RutasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rutas, container, false);
    }

}
