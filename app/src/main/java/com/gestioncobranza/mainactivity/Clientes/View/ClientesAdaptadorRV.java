package com.gestioncobranza.mainactivity.Clientes.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gestioncobranza.mainactivity.Clientes.Clientes;
import com.gestioncobranza.mainactivity.Clientes.Model.Cliente;
import com.gestioncobranza.mainactivity.Clientes.Presenter.ClientesPresenter;
import com.gestioncobranza.mainactivity.R;

import java.util.ArrayList;

public class ClientesAdaptadorRV extends RecyclerView.Adapter<ClientesAdaptadorRV.ClientesViewHolder> {

    private final Context activity;
    private final int resource;
    private final ArrayList<Cliente> clientes;
    private final Clientes.presenter clientesPresenter;

    public ClientesAdaptadorRV(Context activity, int resource, ArrayList<Cliente> clientes, Clientes.presenter clientesPresenter) {
        this.activity = activity;
        this.resource = resource;
        this.clientes = clientes;
        this.clientesPresenter = clientesPresenter;
    }

    @NonNull
    @Override
    public ClientesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        return new ClientesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientesViewHolder holder, int position) {
        Cliente item = clientes.get(position);

        holder.nombre.setText(item.getNombre());
        holder.descripcion.setText(item.getTelefono());
        holder.fecha.setText(item.getDireccion());
    }

    @Override
    public int getItemCount() {
        return clientes.size();
    }

    public class ClientesViewHolder extends RecyclerView.ViewHolder {

        View item;
        TextView nombre;
        TextView descripcion;
        TextView fecha;

        public ClientesViewHolder(@NonNull View itemView) {
            super(itemView);
            this.item = itemView;
            this.nombre = itemView.findViewById(R.id.item_nombre);
            this.descripcion = itemView.findViewById(R.id.item_descripcion);
            this.fecha = itemView.findViewById(R.id.item_fecha);
        }
    }
}
