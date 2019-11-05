package com.gestioncobranza.mainactivity.Rutas.View.Adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RutasAdaptador extends RecyclerView.Adapter<RutasAdaptador.RutasViewHolder> {

    @NonNull
    @Override
    public RutasAdaptador.RutasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RutasAdaptador.RutasViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class RutasViewHolder extends RecyclerView.ViewHolder {
        public RutasViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
