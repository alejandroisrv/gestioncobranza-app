package com.gestioncobranza.mainactivity.Productos.Model;

public class Entrega {
    int id;
    String comentario;
    int estado;
    String fecha;

    public Entrega(int id, String comentario, int estado, String fecha) {
        this.id = id;
        this.comentario = comentario;
        this.estado = estado;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
