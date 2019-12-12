package com.gestioncobranza.mainactivity.Rutas;

import com.gestioncobranza.mainactivity.DB.RutaDB;
import com.gestioncobranza.mainactivity.MainInterface;
import com.gestioncobranza.mainactivity.Rutas.Model.Ruta;

import java.util.ArrayList;

public interface Rutas {
    interface view extends MainInterface.view {
        void showData(ArrayList<Ruta> rutas);
        void showItem(Ruta ruta);
    }

    interface presenter extends MainInterface.presenter {
        void showData(ArrayList<Ruta> rutas);
        void showItem(Ruta ruta);
    }
    interface interactor extends MainInterface.interactor {

    }

    interface repository extends MainInterface.repository {

    }
}
