package com.gestioncobranza.mainactivity.Cobros.Model;

import java.util.ArrayList;

public class Cobro {

    int id;
    String ruta;
    int estado;
    String fecha_inicio;
    ArrayList<ItemCobro> itemCobros;

    public Cobro(int id, String ruta, int estado, String fecha_inicio, ArrayList<ItemCobro> itemCobros) {
        this.id = id;
        this.ruta = ruta;
        this.estado = estado;
        this.fecha_inicio = fecha_inicio;
        this.itemCobros = itemCobros;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public ArrayList<ItemCobro> getItemCobros() {
        return itemCobros;
    }

    public void setItemCobros(ArrayList<ItemCobro> itemCobros) {
        this.itemCobros = itemCobros;
    }

    public static class ItemCobro {
        int cobro_id;
        String cliente;
        String direccion;
        String monto;
        int estado;
        String comision;
        String observacion;

        public ItemCobro(int cobro_id, String cliente, String direccion, String monto, int estado, String comision, String observacion) {
            this.cobro_id = cobro_id;
            this.cliente = cliente;
            this.direccion = direccion;
            this.monto = monto;
            this.estado = estado;
            this.comision = comision;
            this.observacion = observacion;
        }

        public int getCobro_id() {
            return cobro_id;
        }

        public void setCobro_id(int cobro_id) {
            this.cobro_id = cobro_id;
        }

        public String getCliente() {
            return cliente;
        }

        public void setCliente(String cliente) {
            this.cliente = cliente;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public String getMonto() {
            return monto;
        }

        public void setMonto(String monto) {
            this.monto = monto;
        }

        public int getEstado() {
            return estado;
        }

        public void setEstado(int estado) {
            this.estado = estado;
        }

        public String getComision() {
            return comision;
        }

        public void setComision(String comision) {
            this.comision = comision;
        }

        public String getObservacion() {
            return observacion;
        }

        public void setObservacion(String observacion) {
            this.observacion = observacion;
        }
    }
}
