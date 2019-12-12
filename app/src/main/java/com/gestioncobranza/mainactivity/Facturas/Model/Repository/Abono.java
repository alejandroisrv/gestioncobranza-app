package com.gestioncobranza.mainactivity.Facturas.Model.Repository;

public class Abono {
    int id;
    String cliente;
    String monto;
    String saldo;
    String fecha;

    public Abono(int id, String cliente, String monto, String saldo, String fecha) {
        this.id = id;
        this.cliente = cliente;
        this.monto = monto;
        this.saldo = saldo;
        this.fecha = fecha;
    }
}
