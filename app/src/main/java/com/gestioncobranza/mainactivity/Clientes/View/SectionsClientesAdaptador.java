package com.gestioncobranza.mainactivity.Clientes.View;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gestioncobranza.mainactivity.Clientes.Clientes;
import com.gestioncobranza.mainactivity.Clientes.Model.Cliente;
import com.gestioncobranza.mainactivity.R;
import com.gestioncobranza.mainactivity.Rutas.Model.Ruta;

import java.util.ArrayList;

public class SectionsClientesAdaptador extends RecyclerView.Adapter<SectionsClientesAdaptador.SectionsClientesViewHolder> {
    public ArrayList<Ruta> rutas;
    private int resource;
    private Activity activity;
    Clientes.presenter ClientesPresenter;

    public SectionsClientesAdaptador(ArrayList<Ruta> rutas, int resource, Activity activity, Clientes.presenter clientesPresenter) {
        this.rutas = rutas;
        this.resource = resource;
        this.activity = activity;
        this.ClientesPresenter = clientesPresenter;
    }

    @NonNull
    @Override
    public SectionsClientesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        return new SectionsClientesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SectionsClientesViewHolder holder, int position) {

        final Ruta ruta = rutas.get(position);

        ArrayList<Cliente> clientes = ruta.getClientes();

        holder.title.setText(ruta.getNombre());
        holder.load_more.setText(activity.getResources().getString(R.string.list_item_load_more));

        ClientesAdaptadorRV itemListDataAdapter = new ClientesAdaptadorRV (activity,R.layout.cardview_clientes,clientes,ClientesPresenter);
        holder.list_clientes.setHasFixedSize(true);
        holder.list_clientes.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));
        holder.list_clientes.setAdapter(itemListDataAdapter);
        holder.list_clientes.setNestedScrollingEnabled(false);

        holder.load_more.setOnClickListener(view -> {
            Intent intent = new Intent(activity, ClientesRutasActivity.class);
            intent.putExtra("id",ruta.getId());
            intent.putExtra("nombre",ruta.getNombre());
            activity.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return rutas.size();
    }

    public class SectionsClientesViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView load_more;
        private RecyclerView list_clientes;

        public SectionsClientesViewHolder(@NonNull View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.header_section_title);
            this.load_more = itemView.findViewById(R.id.header_section_load_more);
            this.list_clientes = itemView.findViewById(R.id.recycler_view_list);
        }
    }
}
