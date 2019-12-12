package com.gestioncobranza.mainactivity.DB;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RutaDB {

    @SerializedName("RT")
    @Expose
    private ArrayList<Ruta> RT = null;

    public ArrayList<Ruta> getRT() {
        return RT;
    }

    public void setRT(ArrayList<Ruta> RT) {
        this.RT = RT;
    }

    public class Ruta {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("sucursal_id")
        @Expose
        private Integer sucursalId;
        @SerializedName("municipio_id")
        @Expose
        private Integer municipioId;
        @SerializedName("nombre")
        @Expose
        private String nombre;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("items")
        @Expose
        private ArrayList<Item> items = null;

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

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public ArrayList<Item> getItems() {
            return items;
        }

        public void setItems(ArrayList<Item> items) {
            this.items = items;
        }

    }

    public class Item {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("ruta_id")
        @Expose
        private Integer rutaId;
        @SerializedName("cliente_id")
        @Expose
        private Integer clienteId;
        @SerializedName("orden")
        @Expose
        private Integer orden;
        @SerializedName("clienteNombre")
        @Expose
        private String clienteNombre;
        @SerializedName("clienteDireccion")
        @Expose
        private String clienteDireccion;

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

        public String getClienteNombre() {
            return clienteNombre;
        }

        public void setClienteNombre(String clienteNombre) {
            this.clienteNombre = clienteNombre;
        }

        public String getClienteDireccion() {
            return clienteDireccion;
        }

        public void setClienteDireccion(String clienteDireccion) {
            this.clienteDireccion = clienteDireccion;
        }
    }
}
