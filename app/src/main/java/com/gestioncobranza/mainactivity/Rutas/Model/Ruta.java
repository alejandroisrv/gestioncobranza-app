package com.gestioncobranza.mainactivity.Rutas.Model;


import com.gestioncobranza.mainactivity.Clientes.Model.Cliente;
import com.gestioncobranza.mainactivity.DB.ClienteDB;

import java.util.ArrayList;
import java.util.List;

public class Ruta {


    public static final Integer CLIENTES_SIN_RUTAS_ID = 0;
    public static final String CLIENTES_SIN_RUTAS_NOMBRE = "Clientes sin ruta";
    private Integer id;

        private Integer sucursalId;
        private Integer municipioId;
        private String nombre;
        private ArrayList<Cliente> clientes;

    public Ruta(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Ruta(Integer id, String nombre, ArrayList<Cliente> clientes) {
        this.id = id;
        this.nombre = nombre;
        this.clientes = clientes;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    private List<Item> items = null;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getSucursalId() {
            return sucursalId;
        }

        public void setSucursalId(Integer sucursalId) {
            this.sucursalId = sucursalId;
        }

        public Integer getMunicipioId() {
            return municipioId;
        }

        public void setMunicipioId(Integer municipioId) {
            this.municipioId = municipioId;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public List<Item> getItems() {
            return items;
        }

        public void setItems(List<Item> items) {
            this.items = items;
        }

    public class Item {

        private Integer id;
        private Integer rutaId;
        private Integer clienteId;
        private Integer orden;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getRutaId() {
            return rutaId;
        }

        public void setRutaId(Integer rutaId) {
            this.rutaId = rutaId;
        }

        public Integer getClienteId() {
            return clienteId;
        }

        public void setClienteId(Integer clienteId) {
            this.clienteId = clienteId;
        }

        public Integer getOrden() {
            return orden;
        }

        public void setOrden(Integer orden) {
            this.orden = orden;
        }

    }


}
