package com.gestioncobranza.mainactivity.Cobros;

import com.gestioncobranza.mainactivity.Cobros.Model.Cobro;
import com.gestioncobranza.mainactivity.Cobros.Model.CobroResultado;
import com.gestioncobranza.mainactivity.DB.CobroDB;
import com.gestioncobranza.mainactivity.MainInterface;

import java.util.ArrayList;

public interface Cobros {

    interface view extends MainInterface.view{
        void showDetail();
        void showData(ArrayList<Cobro> cobros);
        void showItem(Cobro cobro);
        void sendResult(CobroResultado cobroResultado);
    }

    interface presenter extends MainInterface.presenter {
        void showData(ArrayList<Cobro> cobros);
        void showItem(Cobro cobro);
        void sendResult(CobroResultado cobroResultado);
    }

    interface interactor extends MainInterface.interactor{
        void sendResult(CobroResultado cobroResultado);
    }

    interface repository extends MainInterface.repository {
        void saveCobros(ArrayList<CobroDB.Cobro> cobros);
        void sendResult(CobroResultado cobroResultado);
    }

    interface itemsCobroRepository {
        void saveItems(ArrayList<CobroDB.CobroItem> items);

        ArrayList<Cobro.ItemCobro> getItemsCobro(int id);
    }
}
