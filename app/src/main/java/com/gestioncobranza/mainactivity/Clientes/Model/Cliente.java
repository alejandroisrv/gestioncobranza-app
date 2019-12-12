package com.gestioncobranza.mainactivity.Clientes.Model;

import com.gestioncobranza.mainactivity.DB.ClienteDB;
import com.gestioncobranza.mainactivity.Rutas.Model.Ruta;

public class Cliente {

    int id;
    int cod;
    String nombre;
    String email;
    String cedula;
    String direccion;
    String deuda;
    String telefono;
    String informacion_adicional;
    Ruta ruta;
    String municipio;
    int municipio_id;
    ClienteDB.PagosCliente pagos = null;

    public Cliente(int id, int cod, String nombre, String email, String cedula, String direccion, String deuda, String telefono, String informacion_adicional, Ruta ruta, String municipio, int municipio_id, ClienteDB.PagosCliente pagos) {
        this.id = id;
        this.cod = cod;
        this.nombre = nombre;
        this.email = email;
        this.cedula = cedula;
        this.direccion = direccion;
        this.deuda = deuda;
        this.telefono = telefono;
        this.informacion_adicional = informacion_adicional;
        this.ruta = ruta;
        this.municipio = municipio;
        this.municipio_id = municipio_id;
        this.pagos = pagos;
    }

    public Cliente(int id, int cod, String nombre, String email, String cedula, String direccion, String deuda, String telefono, String informacion_adicional, Ruta ruta, int municipio_id) {
        this.id = id;
        this.cod = cod;
        this.nombre = nombre;
        this.email = email;
        this.cedula = cedula;
        this.direccion = direccion;
        this.deuda = deuda;
        this.telefono = telefono;
        this.informacion_adicional = informacion_adicional;
        this.ruta = ruta;
        this.municipio_id = municipio_id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getMunicipio_id() {
        return municipio_id;
    }

    public void setMunicipio_id(int municipio_id) {
        this.municipio_id = municipio_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDeuda() {
        return deuda;
    }

    public void setDeuda(String deuda) {
        this.deuda = deuda;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getInformacion_adicional() {
        return informacion_adicional;
    }

    public void setInformacion_adicional(String informacion_adicional) {
        this.informacion_adicional = informacion_adicional;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public ClienteDB.PagosCliente getPagos() {
        return pagos;
    }

    public void setPagos(ClienteDB.PagosCliente pagos) {
        this.pagos = pagos;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
}
