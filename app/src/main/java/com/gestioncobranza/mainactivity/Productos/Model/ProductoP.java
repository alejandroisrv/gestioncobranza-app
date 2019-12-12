package com.gestioncobranza.mainactivity.Productos.Model;

public class ProductoP {

    int id;
    String nombre;
    String descripcion;
    int cantidad;
    String precio_contado;
    String precio_credito;
    String imagen;

    public ProductoP(int id, String nombre, String descripcion, int cantidad, String precio_contado, String precio_credito, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio_contado = precio_contado;
        this.precio_credito = precio_credito;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecio_contado() {
        return precio_contado;
    }

    public void setPrecio_contado(String precio_contado) {
        this.precio_contado = precio_contado;
    }

    public String getPrecio_credito() {
        return precio_credito;
    }

    public void setPrecio_credito(String precio_credito) {
        this.precio_credito = precio_credito;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
