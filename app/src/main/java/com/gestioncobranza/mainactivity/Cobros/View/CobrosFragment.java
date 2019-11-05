package com.gestioncobranza.mainactivity.Cobros.View;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gestioncobranza.mainactivity.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CobrosFragment extends Fragment {


    public CobrosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_cobros, container, false);
    }

}
